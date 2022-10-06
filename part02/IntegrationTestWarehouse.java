package part02;

import part01.Department;
import part01.Warehouse;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124 
 */
public class IntegrationTestWarehouse {

	public static void main(String[] args) {
		testCase6();
		testCase7();
		testCase8();
		testCase9();
		testCase10();
		testCase11();
		testCase12();
		testCase13();
		testCase14();
	}
	
	private static void testCase6() {
		System.out.println("++++++++++++ Test Case 6: addProduct() - ADDITION SUCCESS ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		
		try {
			System.out.println("List of Products before Addition: ");
			System.out.println(ware1.toString());
			
			System.out.println("Adding new product...");
			System.out.println("Expected Test Status: OK");
			System.out.println("Actual Test Status: " + ware1.addProduct("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL));
			System.out.println();
			
			System.out.println("List of Products after Addition: ");
			System.out.println(ware1.toString());
			
		}catch (Exception ex) {
			System.out.println("Exception");
		}
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 6 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase7() {
		System.out.println("++++++++++++ Test Case 7: addProduct() - ADDITION FAILED ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS, 4);
		
		System.out.println("List of Products before Addition: ");
		System.out.println(ware1.toString());
			
		System.out.println("Adding product with same make & model...");
		System.out.println("Expected Test Status: ADDITION FAILED - Product should not have the same make & model.");
		System.out.println("Actual Test Status: " + ware1.addProduct("Make1", "Model1", 10, Department.BOOKS, 3));
		System.out.println();
			
		System.out.println("List of Products after Addition: ");
		System.out.println(ware1.toString());
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 7 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase8() {
		System.out.println("++++++++++++ Test Case 8: deleteProduct() TRUE CHECK ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS);
		
		System.out.println("List of Products before Addition: ");
		System.out.println(ware1.toString());
			
		System.out.println("Deleting product");
		System.out.println("Expected Test Status: true");
		System.out.println("Actual Test Status: " + ware1.deleteProduct("B0003"));
		System.out.println();
			
		System.out.println("List of Products after Addition: ");
		System.out.println(ware1.toString());
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 8 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase9() {
		System.out.println("++++++++++++ Test Case 9: deleteProduct() FALSE CHECK ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS);
		
		System.out.println("List of Products before Addition: ");
		System.out.println(ware1.toString());
			
		System.out.println("Deleting product");
		System.out.println("Expected Test Status: false");
		System.out.println("Actual Test Status: " + ware1.deleteProduct("B0007"));
		System.out.println();
			
		System.out.println("List of Products after Addition: ");
		System.out.println(ware1.toString());
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 9 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase10() {
		System.out.println("++++++++++++ Test Case 10: restock() TRUE CHECK ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make2", "Model2", 9, Department.COMPUTING, 2);
		
		System.out.println("Product details before Restock: ");
		System.out.println(ware1.toString());
			
		int amnt = 3;
		System.out.println("Restocking product by: " + amnt);
		System.out.println("Expected Test Status: true");
		System.out.println("Actual Test Status: " + ware1.restock("C0005", amnt));
		System.out.println();
			
		System.out.println("Product details after Restock: ");
		System.out.println(ware1.toString());
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 10 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase11() {
		System.out.println("++++++++++++ Test Case 11: restock() FALSE CHECK ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make2", "Model2", 9, Department.COMPUTING, 2);
		
		System.out.println("Product details before Restock: ");
		System.out.println(ware1.toString());
			
		int amnt = -3;
		System.out.println("Restocking product by: " + amnt);
		System.out.println("Expected Test Status: false");
		System.out.println("Actual Test Status: " + ware1.restock("C0006", amnt));
		System.out.println();
			
		System.out.println("Product details after Restock: ");
		System.out.println(ware1.toString());
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 11 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase12() {
		System.out.println("++++++++++++ Test Case 12: search() method Test - SEARCH SUCCESS ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS, 4);
		ware1.addProduct("Make2", "Model2", 9, Department.COMPUTING, 2);
		ware1.addProduct("Make3", "Model3", 15, Department.OTHER);
		
		System.out.println("Product List:");
		System.out.println(ware1.toString());
		System.out.println("Searching for product...");
		System.out.println(ware1.search("B0007"));
		System.out.println();
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 12 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase13() {
		System.out.println("++++++++++++ Test Case 13: search() method Test - SEARCH FAIL ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS, 4);
		ware1.addProduct("Make2", "Model2", 9, Department.COMPUTING, 2);
		ware1.addProduct("Make3", "Model3", 15, Department.OTHER);
		
		System.out.println("Product List:");
		System.out.println(ware1.toString());
		System.out.println("Searching for product...");
		System.out.println(ware1.search("B0009"));
		System.out.println();
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 13 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase14() {
		System.out.println("++++++++++++ Test Case 14: toString() Format Test ++++++++++++");
		System.out.println();
		
		Warehouse ware1 = new Warehouse("myWare");
		ware1.addProduct("Make1", "Model1", 10, Department.BOOKS);
		ware1.addProduct("Make2", "Model2", 9, Department.COMPUTING);
		ware1.addProduct("Make3", "Model3", 15, Department.OTHER);
		ware1.addProduct("Make4", "Model4", 19, Department.BOOKS);
		
		System.out.println("Product List:");
		System.out.println(ware1.toString());
		System.out.println();
		
		System.out.println("+++++++++++++++++++++++++ End of Test Case 14 ++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	

}
