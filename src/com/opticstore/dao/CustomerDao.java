package com.opticstore.dao;

import org.springframework.stereotype.Component;

import com.opticstore.model.customer.Customer;

@Component
public class CustomerDao extends AbstractDao<Customer>  {

    @Override
    public void add(Customer customer) {
        getCustomerMap().put(customer.getId(), customer);
    }


    @Override
    public Customer find(Customer customer) {
    	
    	Customer newCustomer = getCustomerMap().get(customer.getId());
    	
    	if (newCustomer == null) {
    		return null;
    	}
    	
        return newCustomer.getName().equals(customer.getName()) ? newCustomer : null;
    }
}
