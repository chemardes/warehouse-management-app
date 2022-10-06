package part01;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class WarehouseApp { 
	
	static Warehouse ware1 = new Warehouse("myWare");
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		instatiateData();
		String options[] = {"Add New Product", "Delete a Product", "List Products for Department", "List All Products", 
				"Add Stock for a Product", "Sales Report", "Record Purchase", "Exit"};
		Menu wareMenu = new Menu("Warehouse Management App", options);
		int choice;
		boolean done = false;
		do {
			choice = wareMenu.getUserChoice();
			if(choice == options.length) {
				break;
			}
			processChoice(choice);
		}while(!done);
		
		System.out.println("Exit Application");
	}
	
	/**
	 * This method is used to create Product instances (for each department) into the system 
	 */
	private static void instatiateData() {
		ware1.addProduct("Philips", "Blender", 50.99, Department.ELECTRICAL);
		ware1.addProduct("Bloomsbury", "Harry Potter & The Philosopher's Stone", 7.99, Department.BOOKS);
		ware1.addProduct("LG", "HD TV", 800, Department.ELECTRICAL);
		ware1.addProduct("Harper", "The Poppy War", 8.99, Department.BOOKS);
		ware1.addProduct("Cool Cameras", "Camera 1", 120, Department.PHOTOGRAPHIC);
		ware1.addProduct("Cool Cameras", "Camera 2", 180.59, Department.PHOTOGRAPHIC);
		ware1.addProduct("DELL", "Model2", 400, Department.COMPUTING);
		ware1.addProduct("HP", "Model1", 459.99, Department.COMPUTING);
		ware1.addProduct("Zara", "Turtleneck Shirt", 49.99, Department.FASHION);
		ware1.addProduct("H&M", "Wide Leg Jeans", 55, Department.FASHION);
		ware1.addProduct("Tokyo Records", "LOONA [XX] Album Version A", 26.99, Department.MUSIC);
		ware1.addProduct("Galaxy Music", "Piano Keyboard 1", 250, Department.MUSIC);
		ware1.addProduct("Kitchen Village", "Chef Knife Set", 99.99, Department.OTHER);
		ware1.addProduct("Biker Nation", "Tricycle", 199.99, Department.OTHER);
	}

	/**
	 * This method is used to determine which method is called to perform the system operations when the user makes an input choice
	 * @param choice - the choice input the user inputs
	 */
	private static void processChoice(int choice) {
		switch(choice) {
		case 1:
			addProduct();
			break;
		case 2:
			deleteProduct();
			break;
		case 3:
			listDeptProducts();
			break;
		case 4:
			listAllProducts();
			break;
		case 5:
			addStock();
			break;
		case 6:
			showSalesReport();
			break;
		case 7:
			recordPurchases();
			break;
		default:
			System.out.println("Error - Invalid Option.");
		}
	}
	
	/**
	 * This method is used to add a new product to the Warehouse
	 */
	private static void addProduct() {
		System.out.println("Add a new Product");
		System.out.println("-----------------");
		System.out.print("Make:");
		String newMake = input.nextLine();
		System.out.print("Model:");
		String newModel = input.nextLine();
		System.out.print("Price:");
		double newPrice = input.nextDouble();
		input.nextLine();
		System.out.print("Department:");
		Department newDept = Department.valueOf(input.nextLine().toUpperCase());
		System.out.print("Quantity:");
		int newQty = input.nextInt();
		input.nextLine();
		System.out.println("Adding product...");
		
		System.out.println(ware1.addProduct(newMake, newModel, newPrice, newDept, newQty));
		System.out.println();
	}
	
	/**
	 * This method is used to remove a product from the Warehouse
	 */
	private static void deleteProduct() {
		System.out.println("Delete a Product");
		System.out.println("----------------");
		System.out.print("Input product code for product deletion: ");
		String newCode = input.nextLine().toUpperCase();
		System.out.println("Deleting product...");
		newCode = newCode.trim();
		if(ware1.deleteProduct(newCode) == true) {
			System.out.println("Product has been deleted.");
		}else {
			System.out.println("Product deletion FAILED");
		}
		System.out.println();
	}
	
	/**
	 * This method displays the product details for a particular department
	 */
	private static void listDeptProducts() {
		System.out.println("List Products from a Department");
		System.out.println("-------------------------------");
		System.out.print("Input a department: ");
		Department newDept = Department.valueOf(input.nextLine().toUpperCase().trim());
		System.out.println("Compiling product list...");
		System.out.println();
		ArrayList<Product> temp = ware1.search(newDept);
		if(temp!=null) {
			for(Product prod: temp) {
				System.out.println(prod.toString());
			}	
			System.out.println();
			System.out.println("Product List Compilation COMPLETED.");
		}
		
		System.out.println();
		
	}
	
	/**
	 * This method is used to list down all the products within the Warehouse System
	 */
	private static void listAllProducts() {
		System.out.println("List All Products in all Departments");
		System.out.println("------------------------------------");
		System.out.println("Compiling all products...");
		System.out.println();
		System.out.println(ware1.toString());
		System.out.println("Product Compilation COMPLETED.");
		System.out.println();
	}
	
	/**
	 * This method is used to update the stock quantity of a product 
	 */
	private static void addStock() {
		System.out.println("Add Stock Quantity");
		System.out.println("------------------");
		System.out.println("Input product code: ");
		String newCode = input.nextLine().toUpperCase();
		newCode = newCode.trim();
		System.out.println("Input quantity to add: ");
		int qty = input.nextInt();
		input.nextLine();
		System.out.println("Adding stock...");
		if(ware1.restock(newCode, qty) == true) {
			System.out.println("Product has been restocked.");
		}else {
			System.out.println("Product Restock FAILED");
		}
		System.out.println();
	}
	
	/**
	 * This method is used to display sales information for all products 
	 * and is ordered by lowest to highest number of sales
	 */
	private static void showSalesReport() {
		System.out.println("Show Sales Report");
		System.out.println("-----------------");
		System.out.println("Displaying Sales Report...");
		System.out.println();
		// use bubble sort to sort purchases in ascending order
		Product data[] = ware1.getAllProducts();
		sort(data);
		
		for(int i=0; i<data.length; i++) {
			System.out.println("Number of Sales: " + data[i].getPurchases() + " | " + data[i].toString());
		}
		System.out.println();
		System.out.println("Sales Report Displayed.");
		System.out.println();
	}
	
	/**
	 * This method is used to record purchases for a specific product
	 */
	private static void recordPurchases() {
		System.out.println("Record purchases");
		System.out.println("---------------");
		System.out.println("Input product code: ");
		String newCode = input.nextLine().toUpperCase();
		newCode = newCode.trim();
		System.out.println("Input number of purchases: ");
		int newPurchases = input.nextInt();
		input.nextLine();
		System.out.println("Recording Purchases...");
		Product myWare = ware1.search(newCode);
		if(myWare != null) {
			if(myWare.recordPurchase(newCode, newPurchases) == true) {
				System.out.println("Purchase has been recorded.");
			}else if(newPurchases > myWare.getQuantity()){
				System.out.println("Not enough stock to make purchase");
			}else {
				System.out.println("Recording Purchases FAILED.");
			}
		}else {
			System.out.println("Recording Purchases FAILED.");
		}
		
		System.out.println();
	}
	
	/**
	 * This bubble sort method is used to sort the number of purchases from lowest to highest
	 * @param data - the array of products
	 */
	private static void sort(Product[] data) {
		int swaps;
		do {
			swaps = 0;
			for(int i=0; i<data.length-1;i++) {
				if(data[i].getPurchases() > data[i+1].getPurchases()) {
					Product temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
					swaps++;
				}
			}
		}while(swaps>0);
	}

}