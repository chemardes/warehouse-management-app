package part01;

import java.util.ArrayList;

/**
 * @author Chelsea De Marseilla
 * Student iD: 40329124
 */
public class Warehouse implements iWare{
	protected ArrayList<Product> data;
	protected String name;
	
	/**
	 * This is the constructor method for the Warehouse object
	 * @param name
	 */
	public Warehouse(String name) {
		this.name = name;
		this.data = new ArrayList <Product>(); 
	}
	
	/**
	 * This accessor method returns the the name of the Warehouse owner
	 * @return This.name - the Warehouse owner
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method returns an array of product references
	 * @return array if product is available | null if product is unavailable 
	 */
	public Product[] getAllProducts() {
		int size = data.size();
		Product[] products =  new Product[size];
		
		for(int i=0; i<size; i++) {
			products[i] = data.get(i);
		}
		return products;
	}
	
	/**
	 * This method adds a product without specifying the initial quantity of product available
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @return "OK" message if addition of product is a success | "Error" message if addition is a failure
	 */
	public String addProduct(String make, String model, double price, Department dept){
		int size = data.size();
		
		for(int i=0; i<size; i++) {
			Product oneProduct;
			oneProduct = data.get(i);
			
			if(oneProduct.getMake().equals(make) && oneProduct.getModel().equals(model)) {
				return "ADDITION FAILED - Product should not have the same make & model.";
			}
		}
		Product newProduct = new Product(make, model, price, dept);
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
	 */
	public String addProduct(String make, String model, double price, Department dept, int qty) {
		int size = data.size();
		
		for(int i=0; i<size; i++) {
			Product oneProduct;
			oneProduct = data.get(i);
			
			if(oneProduct.getMake().equals(make) && oneProduct.getModel().equals(model)) {
				return "ADDITION FAILED - Product should not have the same make & model.";
			}
			
		}
		Product newProduct = new Product(make, model, price, dept, qty);
		if(newProduct.getQuantity()<0) {
			return "ADDITION FAILED - Product should not be a negative number";
			
		}else {
			data.add(newProduct);
			//return String.valueOf(newProduct.getQuantity());
			return "OK";
		}
		
		
		// data.add(new Product(make, model, price, dept));
		//return "OK";
		
	}
	
	/**
	 * This method is used to delete a product and returns a boolean value 
	 * @param pCode - the product code
	 * @return true denotes success in product deletion | false denotes failure in product deletion
	 */
	public boolean deleteProduct(String pCode) {
		if(pCode == null) {
			return false;
		}
		
		Product temp = search(pCode);
		if(temp!=null) {
			data.remove(temp);
			return true;
		}
		return false;
		 
	}
	
	/**
	 * This method is used to update stock quantitites for a certain product and returns a boolean value
	 * 
	 * @param pCode - the product code used to re-stock a product
	 * @param quantity - the quantity of product re-stocked
	 * @return true denotes success in product re-stock | false denotes failure in product re-stock
	 */
	public boolean restock(String pCode, int quantity) {
		Product temp = search(pCode);
		if(temp != null && quantity > 0) {
			temp.addToQuantity(quantity);
			return true;
 		}
		return false;
	}
	
	/**
	 * This method searches for a product using its corresponding product code
	 * 
	 * @param code - the product code
	 * @return temp - the product being searched for | null if product unavailable
	 */
	public Product search(String code) {
		if(code == null) {
			return null;
		}
		
		for(int i=0; i<data.size();i++) {
			Product temp = data.get(i);
			String thisCode = temp.getCode();
			if(thisCode.equals(code)) {
				return temp;
			}
		}
		return null;
		
	}
	
	/**
	 * This method searches for the product using its corresponding manufacturer and model
	 * 
	 * @param make - the manufacturer of the product
	 * @param model - the product model
	 * @return temp - the product being searched for | null if product unavailable
	 */
	public Product search(String make, String model) {
		if(make == null && model == null) {
			return null;
		}
		
		for(int i=0; i<data.size(); i++) {
			Product temp = data.get(i);
			String thisMake = temp.getMake();
			String thisModel = temp.getModel();
			if(thisMake.equals(make) && thisModel.equals(model)) {
				return temp;
			}
		}
		return null;
		
	}
	
	/**
	 * This method searches for products within a certain department and returns an arraylist 
	 * 
	 * @param dept - the department at which the products belong to
	 * @return products - the product contained in a specific department | null if product unspecified
	 */
	public ArrayList<Product> search(Department dept){
		if(dept == null) {
			return null;
		}
		
		ArrayList<Product> products = new ArrayList<Product>();
		for(int i=0; i<data.size(); i++) {
			Product temp = data.get(i);
			Department thisDept = temp.getDepartment();
			if(thisDept == dept) {
				products.add(temp);
			}
		}
		return products;
	}
	
	/**
	 * This method returns the string content containing the details of the product 
	 * and is arranged according to their corresponding department
	 * 
	 * @return str - the string content containing product details
	 */
	public String toString() {
		String str = "";
		for(Department dept: Department.values()) {
			ArrayList<Product> temp = search(dept);
			for(Product prod: temp) {
				str += prod.toString() + "\n";
			}
		}
		return str;
		
	}
}
