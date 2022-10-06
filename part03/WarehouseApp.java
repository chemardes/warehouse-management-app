package part03;

import part01.Department;
import part01.Product;

import java.util.ArrayList;

import javax.swing.ImageIcon;


/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class WarehouseApp { 
	
	static WarehouseDetail ware1 = new WarehouseDetail("myWare");
	
	public static void main(String[] args) {
		instatiateData();
		String options[] = {"Add New Product", "Delete a Product", "List Products for Department", "List All Products", 
				"Add Stock for a Product", "Sales Report", "Record Purchase", "Exit"};
		ConsoleMenu menu = new ConsoleMenu("Warehouse Management App", options);
		int choice;
		boolean done = false;
		do {
			choice = menu.getUserChoice();
			menu.clear();
			if(choice == options.length) {
				break;
			}
			processChoice(menu, choice);
			
		}while(!done);
		
		menu.println("Exit Application");
	}
	
	/**
	 * This method is used to create Product Detail instances (for each department) into the system 
	 */
	private static void instatiateData() {
		// ImageIcon icon = new ImageIcon("Images//dog.jpg");
		ware1.addProduct("Philips", "Blender", 50.99, Department.ELECTRICAL, "This is a brand new Philips Blender", new ImageIcon("Images//blender.png"));
		ware1.addProduct("Bloomsbury", "Harry Potter & The Philosopher's Stone", 7.99, Department.BOOKS, "This is the first Harry Potter book", new ImageIcon("Images//hpbook.png"));
		ware1.addProduct("LG", "HD TV", 800, Department.ELECTRICAL, "This is a premium LG HD TV", new ImageIcon("Images//tv.png"));
		ware1.addProduct("Harper", "The Poppy War", 8.99, Department.BOOKS, "This is the first book in the Poppy War series", new ImageIcon("Images//poppywar.jpg"));
		ware1.addProduct("Cool Cameras", "Camera 1", 120, Department.PHOTOGRAPHIC, "This is the first generation Camera from Cool Cameras", new ImageIcon("Images//camera1.png"));
		ware1.addProduct("Cool Cameras", "Camera 2", 180.59, Department.PHOTOGRAPHIC, "This is the second generation Camera from Cool Cameras", new ImageIcon("Images//camera2.png"));
		ware1.addProduct("DELL", "Model2", 400, Department.COMPUTING, "This is the Model2 Laptop from DELL", new ImageIcon("Images//laptop1.png"));
		ware1.addProduct("HP", "Model1", 459.99, Department.COMPUTING, "This is the Model1 Laptop from HP", new ImageIcon("Images//laptop2.png"));
		ware1.addProduct("Zara", "Turtleneck Shirt", 49.99, Department.FASHION, "This is the limited edition Zara Turtleneck Shirt", new ImageIcon("Images//turtleneck.png"));
		ware1.addProduct("H&M", "Wide Leg Jeans", 55, Department.FASHION, "These are the Wide Leg Jeans from the H&M Summer Collection", new ImageIcon("Images//pants.png"));
		ware1.addProduct("Tokyo Records", "LOONA [XX] Album Version A", 26.99, Department.MUSIC, "This is LOONA's 2nd mini album, featuring hit title track 'Butterfly'", new ImageIcon("Images//album.jpg"));
		ware1.addProduct("Galaxy Music", "Piano Keyboard 1", 250, Department.MUSIC, "This is the 1st generation Piano Keyboard from Galaxy Music", new ImageIcon("Images//keyboard.png"));
		ware1.addProduct("Kitchen Village", "Chef Knife Set", 99.99, Department.OTHER, "This is the exclusive Chef's Knife set from Kitchen Village", new ImageIcon("Images//knifeset.png"));
		ware1.addProduct("Biker Nation", "Tricycle", 199.99, Department.OTHER, "This is Biker Nation's new tricycle", new ImageIcon("Images//tricycle.png"));
	}

	/**
	 * This method is used to determine which method is called to perform the system operations when the user makes an input choice
	 * @param menu - the ConsoleMenu
	 * @param choice - the choice input the user inputs
	 */
	private static void processChoice(ConsoleMenu menu, int choice) {
		switch(choice) {
		case 1:
			addProduct(menu);
			break;
		case 2:
			deleteProduct(menu);
			break;
		case 3:
			listDeptProducts(menu);
			break;
		case 4:
			listAllProducts(menu);
			break;
		case 5:
			addStock(menu);
			break;
		case 6:
			showSalesReport(menu);
			break;
		case 7:
			recordPurchases(menu);
			break;
		default:
			menu.println("Error - Invalid Option.");
		}
	}
	
	/**
	 * This method is used to add a new product to the Warehouse
	 * @param menu - the ConsoleMenu
	 */
	private static void addProduct(ConsoleMenu menu) {
		menu.println("Add a new Product");
		menu.println("-----------------");
		menu.print("Make: ");
		String newMake = menu.readLn();
		menu.print("Model: ");
		String newModel = menu.readLn();
		menu.print("Price: ");
		String pValue = menu.readLn();
		double newPrice = Double.parseDouble(pValue);
		menu.print("Department: ");
		Department newDept = Department.valueOf(menu.readLn().toUpperCase());
		menu.print("Quantity: ");
		String qValue = menu.readLn();
		int newQty = Integer.parseInt(qValue);
		menu.print("Description: ");
		String newDesc = menu.readLn();
		// get user to write image path 
		menu.print("Input Image Path (Format - Images//[imagename].[imagetype]): ");
		String imgPath = menu.readLn();
		ImageIcon newImg = new ImageIcon(imgPath);
		// crate image icon 
		menu.println("Adding product...");
		
		menu.println(ware1.addProduct(newMake, newModel, newPrice, newDept, newQty, newDesc, newImg));
		menu.println();
	}
	
	/**
	 * This method is used to remove a product from the Warehouse
	 * @param menu - the ConsoleMenu
	 */
	private static void deleteProduct(ConsoleMenu menu) {
		menu.println("Delete a Product");
		menu.println("----------------");
		menu.print("Input product code for product deletion: ");
		String newCode = menu.readLn().toUpperCase();
		menu.println("Deleting product...");
		newCode = newCode.trim();
		if(ware1.deleteProduct(newCode) == true) {
			menu.println("Product has been deleted.");
		}else {
			menu.println("Product deletion FAILED");
		}
		menu.println();
	}
	
	/**
	 * This method displays the product details for a particular department
     * @param menu - the ConsoleMenu
	 */
	private static void listDeptProducts(ConsoleMenu menu) {
		menu.println("List Products from a Department");
		menu.println("-------------------------------");
		menu.print("Input a department: ");
		Department newDept = Department.valueOf(menu.readLn().toUpperCase().trim());
		menu.println("Compiling product list...");
		menu.println();
		
		ArrayList<ProductDetail> temp = ware1.searchDept(newDept);
		if(temp!=null) {
			for(ProductDetail prod: temp) {
				if(prod.getImage()==null) {
					menu.print("\nImage: There is no image available");
				}else {
					menu.print("Image: ");
					menu.print(prod.getImage());
					menu.println();
				}
				menu.println(prod.toString());
			}	
			menu.println("Product List Compilation COMPLETED.");
			menu.println();
		}
		
//		ArrayList<Product> temp1 = ware1.search(newDept);
//		ArrayList<ProductDetail> temp = new ArrayList<ProductDetail>();
//		for(Product x : temp1) {
//			// product details
//			String code = x.getCode();
//			String make = x.getMake(); 
//			String model = x.getModel();
//			double price = x.getPrice();
//			int quantity = x.getQuantity();
//			int purchases = x.getPurchases();
//			Department dept = x.getDepartment();
//			
//			// product detail extra vars
//			String description = null;
//			ImageIcon image = new ImageIcon();
//			
//			ProductDetail toAdd = new ProductDetail(make, model, price, dept, quantity, description, image);
//			toAdd.setCode(code);
//			temp.add(toAdd);
			//System.out.println(x.getClass());
//		}
//		//ArrayList<ProductDetail> temp = ware1.search(newDept);
//		for(ProductDetail prod: temp) {
//			if(prod.getImage()==null) {
//				menu.print("\nImage: There is no image available.");
//			}else {
//				menu.print("Image: ");
//				menu.print(prod.getImage());
//				menu.println();
//			}
//			
//			menu.println(prod.toString());
//		}
//		menu.println();
//		
	}
	
	/**
	 * This method is used to list down all the products within the Warehouse System
	 * @param menu - the ConsoleMenu
	 */
	private static void listAllProducts(ConsoleMenu menu) {
		menu.println("List All Products in all Departments");
		menu.println("------------------------------------");
		menu.println("Compiling all products...");
		menu.println();
		ware1.getProdInfo(menu);
		menu.println("Product Compilation COMPLETED.");
		menu.println();
	}
	
	/**
	 * This method is used to update the stock quantity of a product 
	 * @param menu - the ConsoleMenu
	 */
	private static void addStock(ConsoleMenu menu) {
		menu.println("Add Stock Quantity");
		menu.println("------------------");
		menu.println("Input product code: ");
		String newCode = menu.readLn().toUpperCase();
		newCode = newCode.trim();
		menu.println("Input quantity to add: ");
		String qValue = menu.readLn();
		int qty = Integer.parseInt(qValue);
		menu.println("Adding stock...");
		if(ware1.restock(newCode, qty) == true) {
			menu.println("Product has been restocked.");
		}else {
			menu.println("Product Restock FAILED");
		}
		menu.println();
	}
	
	/**
	 * This method is used to display sales information for all products 
	 * and is ordered by lowest to highest number of sales
	 * @param menu - the ConsoleMenu
	 */
	private static void showSalesReport(ConsoleMenu menu) {
		menu.println("Show Sales Report");
		menu.println("-----------------");
		menu.println("Displaying Sales Report...");
		menu.println();
		// use bubble sort to sort purchases in ascending order
		
		ProductDetail data[] = ware1.getAllProd();
		
		sort(data);
		
		for(ProductDetail prod: data) {
			if(prod.getImage()==null) {
				menu.print("\nImage: There is no image available\n"); ; 
			}else {
				menu.print("Image: ");
				menu.print(prod.getImage());
				menu.println();
			}
			menu.println("Number of Sales: " + prod.getPurchases() + " | " + prod.toString());
		}
		menu.println("Sales Report Displayed.");
		menu.println();
	}
	
	
	
	/**
	 * This method is used to record purchases for a specific product
	 * @param menu - the ConsoleMenu
	 */
	private static void recordPurchases(ConsoleMenu menu) {
		menu.println("Record purchases");
		menu.println("---------------");
		menu.println("Input product code: ");
		String newCode = menu.readLn().toUpperCase();
		newCode = newCode.trim();
		menu.println("Input number of purchases: ");
		String pValue = menu.readLn();
		int newPurchases = Integer.parseInt(pValue);
		menu.println("Recording Purchases...");
		Product temp = ware1.search(newCode);
		ProductDetail myWare = (ProductDetail)temp;
		if(myWare != null) {
			//myWare.recordPurchase(newCode, newPurchases);
			if(myWare.recordPurchase(newCode, newPurchases) == true) {
				menu.println("Purchase has been recorded.");
			}else if(newPurchases > myWare.getQuantity()){
				menu.println("Not enough stock to make purchase");
			}else {
				menu.println("Recording Purchases FAILED.");
			}
		}else {
			menu.println("Recording Purchases FAILED.");
		}
		
		menu.println();
	}
	
	/**
	 * This bubble sort method is used to sort the number of purchases from lowest to highest
	 * @param data - the array of products
	 */
	private static void sort(ProductDetail[] data) {
		int swaps;
		do {
			swaps = 0;
			for(int i=0; i<data.length-1;i++) {
				if(data[i].getPurchases() > data[i+1].getPurchases()) {
					ProductDetail temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
					swaps++;
				}
			}
		}while(swaps>0);
	}
	
//	private static ProductDetail[] convertListToProductDetail(Product temp[]) {
//			
//		ProductDetail data[] = new ProductDetail[temp.length];
//			
//		for(int i=0;i<temp.length;i++) {
//			// product details
//			String code = temp[i].getCode();
//			String make = temp[i].getMake(); 
//			String model = temp[i].getModel();
//			double price = temp[i].getPrice();
//			int quantity = temp[i].getQuantity();
//			int purchases = temp[i].getPurchases();
//			Department dept = temp[i].getDepartment();
//							
//			// product detail extra vars
//			String description = null;
//			ImageIcon image = new ImageIcon();
//							
//			ProductDetail toAdd = new ProductDetail(make, model, price, dept, quantity, description, image);
//			toAdd.setCode(code);
//			toAdd.setPurchases(purchases);
//			data[i]=(toAdd);
//		}
//			
//			return data;
//		
//	}

}