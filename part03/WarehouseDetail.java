package part03;

import part01.Department;
import part01.Product;
import part01.Warehouse;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import console.Console;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class WarehouseDetail extends Warehouse{

	public WarehouseDetail(String name) {
		super(name);
		
	}
	
	/**
	 * This method adds a product without specifying the initial quantity of product available
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @param description - the description of the product
	 * @param image - the product image
	 * @return "OK" message if addition of product is a success | error message if addition is a failure
	 */
	public String addProduct(String make, String model, double price, Department dept, String description, ImageIcon image){
		int size = data.size();
		
		for(int i=0; i<size; i++) {
			Product oneProduct;
			oneProduct = data.get(i);
			
			if(oneProduct.getMake().equals(make) && oneProduct.getModel().equals(model)) {
				return "ADDITION FAILED - Product should not have the same make & model.";
			}
		}
		ProductDetail newProduct = new ProductDetail(make, model, price, dept, description, image);
		data.add(newProduct);
		
		// data.add(new Product(make, model, price, dept));
		return "OK";
	}
	
	/**
	 * This method adds a product and specifies the initial quantity of product available
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @param qty - the amount of a product available
	 * @param description - the description of the product
	 * @param image - the product image
	 * @return "OK" message if addition of product is a success | error message if addition is a failure
	 */
	public String addProduct(String make, String model, double price, Department dept, int qty, String description, ImageIcon image) {
		int size = data.size();
		
		for(int i=0; i<size; i++) {
			Product oneProduct;
			oneProduct = data.get(i);
			
			if(oneProduct.getMake().equals(make) && oneProduct.getModel().equals(model)) {
				return "ADDITION FAILED - Product should not have the same make & model.";
			}
			
		}
		ProductDetail newProduct = new ProductDetail(make, model, price, dept, qty, description, image);
		if(newProduct.getQuantity()<0) {
			return "ADDITION FAILED - Product should not be a negative number";
			
		}else {
			data.add(newProduct);
			//return String.valueOf(newProduct.getQuantity());
			return "OK";
		}
	}
	
	/**
	 * This method returns an array of product detail references
	 * @return array if product is available | null if product is unavailable 
	 */
	public ProductDetail[] getAllProd() {
		int size = data.size();
		ProductDetail[] products =  new ProductDetail[size];
		
		for(int i=0; i<size; i++) {
			products[i] = (ProductDetail)data.get(i);
		}
		return products;
	}
	
	/**
	 * This method prints out the product details, arranged by their corresponding department, along
	 * with their product images
	 * @param menu - the console
	 */
	public void getProdInfo(Console menu) {
		for(Department dept: Department.values()) {
			ArrayList<ProductDetail> temp = searchDept(dept);
			for(ProductDetail prod: temp) {
				if(prod.getImage()==null) {
					menu.print("\nImage: There is no image available\n"); ; 
				}else {
					menu.print("Image: ");
					menu.print(prod.getImage());
					menu.println();
				}
				
				menu.print(prod.toString() + "\n");
				
			}
		}
	}
	
	/**
	 * This method searches for products within a certain department and returns an arraylist 
	 * 
	 * @param dept - the department at which the products belong to
	 * @return products - the product contained in a specific department | null if product unspecified
	 */
	public ArrayList<ProductDetail> searchDept(Department dept){
		if(dept == null) {
			return null;
		}
		
		ArrayList<ProductDetail> products = new ArrayList<ProductDetail>();
		for(int i=0; i<data.size(); i++) {
			ProductDetail temp = (ProductDetail) data.get(i);
			Department thisDept = temp.getDepartment();
			if(thisDept == dept) {
				products.add(temp);
			}
		}
		return products;
	}
}
