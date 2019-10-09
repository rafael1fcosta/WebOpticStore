package com.opticstore.dao;


import java.util.HashMap;
import java.util.Map;
import com.opticstore.model.customer.Customer;


public abstract class AbstractDao<T> implements Dao<T> {

    private Customer loggedInCustomer;

    private static Map<Integer, Customer> customerMap = new HashMap<>();

    // -----------------------------------------------------------------------------------------------------------------

    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public void setLoggedInCustomer(Customer loggedInCustomer) {
        this.loggedInCustomer = loggedInCustomer;
    }
    
    public void logOut() {
    	this.loggedInCustomer = null;
    }

}
