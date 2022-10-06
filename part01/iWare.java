package part01;

import java.util.ArrayList;

public interface iWare {
	public String getName();
	public Product[] getAllProducts();
	public String addProduct(String make, String model, double price, Department dept);
	public String addProduct(String make, String model, double price, Department dept, int qty);
	public boolean deleteProduct(String pCode);
	public boolean restock(String pCode, int quantity);
	public Product search(String code);
	public Product search(String make, String model);
	public ArrayList<Product> search(Department dept);
	public String toString();
}
