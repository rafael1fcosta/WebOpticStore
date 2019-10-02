package com.opticstore.service;

import java.util.Collection;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opticstore.dao.AbstractDao;
import com.opticstore.model.TestHelperProducts;
import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.customer.Customer;
import com.opticstore.model.customer.Prescription;
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
    public void setClientPrescription(Double sphere, Double cil, Double axis) {
    	
    	if (prescriptionDao.getLoggedInCustomer() == null) {
    		return;
    	}

        prescriptionDao.add(new Prescription(sphere, cil, axis));
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
		
		StringBuilder builder = new StringBuilder();
		
		products.stream()
			.forEach(p -> {
				builder.append(
						"<tr><th scope=\"row\">" + p.getId() + "</th>"
						+	"<td>" + p.getName() + "</td>"
						+	"<td>" + p.getBrand() + "</td>"
						+	"<td>" + p.getPrice() + "</td>"
						+ "<td>"
						+ 	"<form method=\"post\">"
						+ 		"<input type=\"hidden\" name=\"delete\" value=\"" + p.getId() + "\">"
						+ 		"<button class=\"btn btn-sm btn-danger\" type=\"submit\">Delete</button>"
						+ 	"</form>"
						+ "</td>"
						+"</tr>");
			});
		
		return builder.toString();
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
