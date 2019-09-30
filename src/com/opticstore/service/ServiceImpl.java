package com.opticstore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.IntStream;

import javax.print.attribute.IntegerSyntax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opticstore.controller.ShopOptionsProducer;
import com.opticstore.dao.AbstractDao;
import com.opticstore.dao.BrandDao;
import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.ContactsBrand;
import com.opticstore.model.brand.FrameBrand;
import com.opticstore.model.customer.Customer;
import com.opticstore.model.customer.Prescription;


@Service
public class ServiceImpl implements ServiceInterface {

    private AbstractDao<Customer> customerDao;
    private AbstractDao<Prescription> prescriptionDao;
    
    private BrandDao<FrameBrand> frameBrand;
    private BrandDao<ContactsBrand> contactsBrand;

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

	public Collection<Brand> getBrands(ShopOptionsProducer option) {
		
		Collection<Brand> brands = new ArrayList<>();
		
		switch(option) {
			case TEST_ONLY:
				IntStream.range(0, 5).forEach(b -> brands.add(new Brand("Test Brand")));
		}
		
		return brands;
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


	public void setFrameBrand(BrandDao<FrameBrand> frameBrand) {
		this.frameBrand = frameBrand;
	}


	public void setContactsBrand(BrandDao<ContactsBrand> contactsBrand) {
		this.contactsBrand = contactsBrand;
	}
}
