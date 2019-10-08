package com.opticstore.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.product.Lens;
import com.opticstore.model.product.Product;


public class TestHelperProducts {
	
	//for test brands / products
	private static final Brand luxottica = new Brand("Luxotica", BrandType.FRAME);
	private static final Brand persol = new Brand("Persol", BrandType.FRAME);
	
	private static final Brand cooperVision = new Brand("Cooper-Vision", BrandType.CONTACTS);
	private static final Brand bausch = new Brand("Bausch&Lomb", BrandType.CONTACTS);
	
	private static final Product model1 = new Product("Model 1", luxottica, 75.99);
	private static final Product model2 = new Product("Model 2", luxottica, 153.00);
	private static final Product steveMcqueen = new Product("Steve Mcqueen", persol, 199.00);
	
	private static final Product biofinity = new Product("Biofinity", cooperVision, 25.99);
	private static final Product ultraHd = new Product("Ultra HD", bausch, 24.99);
	private static final Product biotrue1day = new Product("Biotrue 1-day", bausch, 17.50);
	
			
	private static Map<Integer, Product> products = new HashMap<>();
	private static Map<Integer, Brand> brands = new HashMap<>();

	
	public static Collection<Product> getTestProducts(BrandType type) {
		
		model1.setImgId(1);
		model2.setImgId(2);
		steveMcqueen.setImgId(3);
		
		products.put(model1.getId(), model1);
		products.put(model2.getId(), model2);
		products.put(steveMcqueen.getId(), steveMcqueen);
		products.put(biofinity.getId(), biofinity);
		products.put(ultraHd.getId(), ultraHd);
		products.put(biotrue1day.getId(), biotrue1day);
		
		return products.values().stream()
				.filter(p -> p.getBrand().getType() == type)
				.collect(Collectors.toList());
	}


	public static Collection<Brand> getTestBrands(BrandType type) {

		brands.put(luxottica.getId(), luxottica);
		brands.put(persol.getId(), persol);
		brands.put(cooperVision.getId(), cooperVision);
		brands.put(bausch.getId(), bausch);
		
		return brands.values().stream()
				.filter(b -> b.getType() == type)
				.collect(Collectors.toList());
	}
	
	public static Product getProduct(Integer id) {
		return products.get(id);
	}


	public static void addLens(Lens lens) {
		products.put(lens.getId(), lens);
	}
	
}
