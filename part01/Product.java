package part01;

public class Product implements iPro{
	private String code;
	private String make; 
	private String model;
	private double price;
	private int quantity;
	private int purchases;
	private Department dept;
	
	private static int codeNo = 1;
	
	/**
	 * This is the constructor method for the Product object
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @param qty - the amount of a product available
	 */
	public Product(String make, String model, double price, Department dept, int qty) {
		if(make != null && model != null) {
			this.make = make;
			this.model = model;
			this.price = price;
			this.dept = dept;
			this.quantity = qty;
			
			this.code = dept.toString().substring(0,1) + String.format("%04d", codeNo);
			codeNo++;
			
		}
		
	}
	
	/**
	 * This is the constructor method for the Product object
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept -  the department at which the product is categorised into
	 */
	public Product(String make, String model, double price, Department dept) {
		if(make != null && model != null) {
			this.make = make;
			this.model = model;
			this.price = price;
			this.dept = dept;
			this.quantity = 1;
			
			this.code = dept.toString().substring(0,1) + String.format("%04d", codeNo);
			codeNo++;	
		}
		
	}
	
	public void setCode(String newCode) {
		this.code = newCode;
		codeNo--;
	}
	
	public void setPurchases(int purchase) {
		this.purchases = purchase;
	}

	/**
	 * This boolean method recordPurchase() records a single purchase of a product if available
	 * @param pCode - the product code
	 * @param purchase - the amount of products purchased
	 * @return true if available | false if unavailable
	 */
	public boolean recordPurchase(String pCode, int purchase) {
		if(this.quantity>0 && this.quantity>=purchase) {
			this.purchases += purchase;
			this.quantity -= purchase;
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This accessor method returns the number of purchases made for a product
	 * @return this.purchases - the number of purchases for a product
	 */
	public int getPurchases() {
		return this.purchases;
	}
	
	/**
	 * This method returns a String containing product details in a single line
	 * @return str - string content containing product details
	 */
	public String toString() {
		String str = "Code: " + getCode() + " | ";;
		str += "Make: " + getMake() + " | ";
		str += "Model: " + getModel() + " | ";
		str += "Price: " + String.format("£%.2f", getPrice()) + " | ";
		str += "Department: " + getDepartment() + " | ";
		str += "Quantity: " + getQuantity();
		return str;
	}
	
	/**
	 * This accessor method returns the product code
	 * @return this.code - the unique Product code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 *  This accessor method returns the product manufacturer
	 * @return this.make - the manufacturer of the product
	 */
	public String getMake() {
		return this.make;
	}
	
	/**
	 *  This accessor method returns the product model
	 * @return this.model - the model of the product
	 */
	public String getModel() {
		return this.model;
	}
	
	/**
	 *  This accessor method returns the product price in pounds
	 * @return this.price - the price of the product
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 *  This accessor method returns the amount of product available
	 * @return this.quantity - the quantity of the product available
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 *  This accessor method returns the associated product department
	 * @return this.dept - the department at which the product is categorised into
	 */
	public Department getDepartment() {
		return this.dept;
	}
	
	/**
	 * This mutator method is used to increase the quantity of products 
	 * @param qty - the quantity of the product available
	 */
	public void addToQuantity(int qty) {
		if(qty > 0) {
			this.quantity += qty;
		}
	}
}
