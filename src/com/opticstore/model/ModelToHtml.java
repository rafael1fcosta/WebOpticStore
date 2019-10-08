package com.opticstore.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Map;

import com.opticstore.model.brand.Brand;
import com.opticstore.model.brand.BrandType;
import com.opticstore.model.customer.Prescription;
import com.opticstore.model.product.Lens;
import com.opticstore.model.product.Product;

public class ModelToHtml {

	public static String createPrescriptionList(Map<Integer, Prescription> prescriptionMap) {
		
		StringBuilder builder = new StringBuilder();
		
		prescriptionMap.values().stream().forEach(p ->
			builder.append(
					"<tr>"
					+ "<th scope='row'>" + p.getId()  + "</th>"
					+ "<td>" + new BigDecimal( p.getSphere()).setScale(2, RoundingMode.HALF_UP) + "</td>"
					+ "<td>" + new BigDecimal( p.getCil()).setScale(2, RoundingMode.HALF_UP) + "</td>"
					+ "<td>" + p.getAxis() + "</td>"
					+ "<td>" + p.getEye().getString() + "</td>"
					+ "</tr>"
					)
		);
		
		return builder.toString();
	}
	
	public static String createBrandTypeList(Collection<Brand> brands) {
		
		StringBuilder builder = new StringBuilder();
		builder.append(BrandType.prefix);
		
		brands.stream().forEach(b -> {
			builder.append(
					BrandType.brandBegin + b.getType().toString() + "/" + b.getId() + "\" class=\"list-group-item\""
					+ BrandType.idBegin + "brand" + b.getId() + BrandType.idEnd + b.getName() + BrandType.brandEnd);
		});
		
		builder.append(BrandType.suffix);
		
		return builder.toString();
	}
	
	public static String createProductHtml(Product product) {
		
		return 
				"<div class=\"col-lg-4 col-md-6 mb-4\" id=\"product" + product.getId() + "\" brand=\"" + product.getBrand().toString() + "\">"
				+ "<div class=\"card h-100\">"
				+ 	"<a href=\"#\"><img class=\"card-img-top\" src=\"http://localhost:8080/OpticStore/resources/" + product.getBrand().getType() + product.getImgId() + ".jpg\" alt=\"\"></a>"
				+ 	"<div class=\"card-body\">"
				+ 		"<h4 class=\"card-title\">"
				+ 			"<a href=\"#\">" + product.getName() + "</a>"
				+ 		"</h4>"
				+ 		"<h5>" + new BigDecimal(product.getPrice()).setScale(2, RoundingMode.HALF_UP) + "&euro;</h5>"
				+ 		"<p class=\"card-text\">Lorem ipsum dolor sit amet, consectetur"
				+ 			"adipisicing elit. Amet numquam aspernatur!</p>"
				+ 	"</div>"
				+ 	"<form method=\"post\">"
				+		"<input type=\"hidden\" name=\"addToCart\" value=\"" + product.getId() + "\">"
				+  		"<button type=\"submit\" class=\"btn btn-warning\" value=\"submit\" style=\"margin: 0px 0px 20px 20px;\">"
				+ 			"Add to cart!"
				+ 		"</button>"
				+ 	"</form>"
				+ "</div>"
				+"</div>";
	}
	
	public static String createProductListInCartHtml(Collection<Product> products, Collection<Prescription> prescriptions, Double totalPrice) {
		
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
					+ 	"</td>"
				);
			
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
								+"</td>"
					);
				}
				
				if (p instanceof Lens) {
					builder.append("<td></td>");
				}
				builder.append("</tr>");
		});
	
	
		builder.append(
			"<tr><th scope=\"row\"></th>"
			+ "<td></td><td></td><td></td>"
			+ "<th>Total:</th><th>" + new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP) + "&euro;</th>"
		);

		return builder.toString();
	}
}
