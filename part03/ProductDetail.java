package part03;

import part01.Product;
import part01.Department;
import javax.swing.ImageIcon;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class ProductDetail extends Product{
	private String description;
	private ImageIcon image;

	/**
	 * This is the constructor method for the ProductDetail object
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @param quantity - the amount of a product available
	 * @param description - the product description
	 * @param image - the product image
	 */
	public ProductDetail(String make, String model, double price, Department dept, int qty, String description, ImageIcon image) {
		super(make, model, price, dept, qty);
		this.description = description;
		this.image = image;
	}
	
	/**
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the price of the product
	 * @param dept - the department at which the product is categorised into
	 * @param description - the product description
	 * @param image - the product image
	 */
	public ProductDetail(String make, String model, double price, Department dept, String description, ImageIcon image) {
		super(make, model, price, dept);
		this.description = description;
		this.image = image;
	}
	
	/**
	 * This accessor method returns the description of the product
	 * @return this.description - the product description
	 */
	public String getDesc() {
		return this.description;
	}
	
	/**
	 * This accessor method returns the image associated with the product
	 * @return this.image - product image
	 */
	public ImageIcon getImage() {
		return this.image;
	}
	
	/**
	 * This accessor method returns the department at which the product belongs to
	 * @return super.getDepartment() - the product department
	 */
	public Department getDept() {
		return super.getDepartment();
	}
	
	@Override
	public String toString() {
		String str = super.toString() +"\n";
		str += "Description: " + getDesc() + "\n";
		//str += "Image: " + image + "\n";
		return str;
	}
}
