package com.opticstore.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opticstore.dao.AbstractDao;
import com.opticstore.model.TestHelperProducts;
import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.customer.Customer;
import com.opticstore.model.customer.Eye;
import com.opticstore.model.customer.Prescription;
import com.opticstore.model.product.Lens;
import com.opticstore.model.product.Product;


@Service
public class ServiceImpl implements ServiceInterface {

    private AbstractDao<Customer> customerDao;
    private AbstractDao<Prescription> prescriptionDao;

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean authenticate(Customer customer) {

        Customer newCustomer = customerDao.find(customer);

        prescriptionDao.setLoggedInCustomer(newCustomer);
        customerDao.setLoggedInCustomer(newCustomer);
        
        return newCustomer != null;
    }

	@Override
    public boolean clientHasPrescription() {

        return !customerDao.getLoggedInCustomer().getPrescriptionMap().isEmpty();

    }

    @Override
    public void setClientPrescription(Double sphere, Double cil, Double axis, String eye) {
    	
    	if (prescriptionDao.getLoggedInCustomer() == null) {
    		return;
    	}

        prescriptionDao.add(new Prescription(sphere, cil, axis, eye));
    }

    public void generateCustomerForTest() {
    	Customer customer = new Customer("raf");
    	customer.setId(1);
    	
    	if (customerDao.find(customer) == null) {
    		customerDao.add(customer);
    	}
    }
    
	public void addCustomer(Customer customer) {
		customerDao.add(customer);
		customerDao.setLoggedInCustomer(customer);
	}
	
	public void addPrescription(Prescription prescription) {
		prescriptionDao.add(prescription);
	}
	
	public Customer getLoggedInCustomer() {
		return customerDao.getLoggedInCustomer();
	}

	public boolean isPrescriptionMapEmpty() {
		return getPrescriptionMap().isEmpty();
	}

	public Map<Integer, Prescription> getPrescriptionMap(){
		return prescriptionDao.getLoggedInCustomer().getPrescriptionMap();
	}

	public boolean clientInDatabase(Customer customer) {
		return customerDao.find(customer) != null;
	}

	public void logOut() {
		customerDao.logOut();
		prescriptionDao.logOut();
	}

	public Collection<Product> getProducts(BrandType type) {
		
		return TestHelperProducts.getTestProducts(type);
	}
	
	public Collection<Brand> getBrands(BrandType type) {
		return TestHelperProducts.getTestBrands(type);
	}
	
	public void addToCart(Integer id) {
		customerDao.getLoggedInCustomer().addToCart(id);
	}
	
	public void removeFromCart(Integer id) {
		customerDao.getLoggedInCustomer().removeFromCart(id);
	}
	
	public String getProductListHtml() {
		Collection<Product> products = customerDao.getLoggedInCustomer().getProductList();
		Collection<Prescription> prescriptions = prescriptionDao.getLoggedInCustomer().getPrescriptionMap().values();
		
		StringBuilder builder = new StringBuilder();
		
		products.stream()
			.forEach(p -> {
				builder.append(
						"<tr><th scope=\"row\" class=\"align-middle\">" + p.getId() + "</th>"
						+	"<td class=\"align-middle\">" + p.getName() + "</td>"
						+	"<td class=\"align-middle\">" + p.getBrand() + "</td>"
						+	"<td class=\"align-middle\">" + new BigDecimal(p.getPrice()).setScale(2, RoundingMode.HALF_UP) + "&euro;</td>"
						+ 	"<td class=\"align-middle\">"
						+ 		"<form method=\"post\">"
						+ 			"<input type=\"hidden\" name=\"delete\" value=\"" + p.getId() + "\">"
						+ 			"<button class=\"btn btn-sm btn-outline-danger\" type=\"submit\" name=\"action\" value=\"delete\">Delete</button>"
						+ 		"</form>"
						+ 	"</td>");
				
				if (!(p instanceof Lens)) {
					builder.append(
								"<td>"
								+ "<form method=\"post\">"
								+ "<div class=\"input-group\">"
								+ 	"<select class=\"custom-select\" id=\"addPrescription" + p.getId() + "\" name=\"add\">"
								+ 		"<option selected disabled value=\"\">Prescription</option>"
								);
					
					prescriptions.stream()
						.forEach(
							presc -> {
								builder.append(
											"<option value=\"" + presc.getId() + " " + p.getBrand().getType() + "\">"
											+ 	presc.getId() + " " + presc.getEye() + " Eye"
											+ "</option>"
										);
							}
						);
								
					builder.append(
								"</select>"
								+ 	"<div class=\"input-group-append\">"
								+ 		"<button class=\"btn btn-outline-secondary\" type=\"submit\" name=\"add\">Add</button>"
								+ 	"</div>"
								+ "</div>"
								+ "</form>"
								+"</td>");
				}
				
				if (p instanceof Lens) {
					builder.append("<td></td>");
				}
				builder.append("</tr>");
			});
		
		Double totalPrice = customerDao.getLoggedInCustomer().getTotalPrice();
		builder.append(
				"<tr><th scope=\"row\"></th>"
				+ "<td></td><td></td><td></td>"
				+ "<th>Total:</th><th>" + new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP) + "&euro;</th>"
				);
		
		
		return builder.toString();
	}
	
	public void addLens(Integer id, Integer price) {
		customerDao.getLoggedInCustomer().addLensToCart(id, price);
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	
    @Autowired
    @Override
    public void setCustomerDao(AbstractDao<Customer> customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    @Override
    public void setPrescriptionDao(AbstractDao<Prescription> prescriptionDao) {
        this.prescriptionDao = prescriptionDao;
    }
}
