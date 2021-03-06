package com.opticstore.model.customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.opticstore.model.AbstractModel;
import com.opticstore.model.TestHelperProducts;
import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.product.Lens;
import com.opticstore.model.product.Product;

public class Customer extends AbstractModel{

    private static Integer customerCounter = 0;

    private String name;
    private Map<Integer, Prescription> prescriptionMap;
    
    private Collection<Product> products;
    
    // -----------------------------------------------------------------------------------------------------------------
    
    public Customer() {
    	this.prescriptionMap = new HashMap<>();
    	this.products = new ArrayList<>();
    }

    public Customer(String name) {
        super.setId(++customerCounter);
        this.name = name;
        this.prescriptionMap = new HashMap<>();
    }
    
 // -----------------------------------------------------------------------------------------------------------------

    public Map<Integer, Prescription> getPrescriptionMap() {
        return prescriptionMap;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void addToCart(Integer id) {
    	products.add(TestHelperProducts.getProduct(id));
    }
    
    public void removeFromCart(Integer id) {
    	products.remove(TestHelperProducts.getProduct(id));
    }
    
    public Collection<Product> getProductList() {
    	return products;
    }
    
    public int getProductCount() {
    	return products.size();
    }
    
    public Double getTotalPrice() {
    	return products.stream().reduce(new Double(0), (partialPrice, p) -> partialPrice + p.getPrice(), Double::sum);
    }

	public void addLensToCart(Integer id, Integer price) {
		String lensName = prescriptionMap.get(id).getEye().getString() + " Eye lens";
		Brand brand = new Brand("Essilor", BrandType.LENS);
		Lens lens = new Lens(lensName, brand, new Double(price));
		
		products.add(lens);
		TestHelperProducts.addLens(lens);
	}
}
