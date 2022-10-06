package part02;

import part01.Department;
import part01.Product;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class UnitTestProduct {

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
	}
	
	private static void testCase1() {
		System.out.println("++++++++++++++++ Test Case 1: toString() Format Test ++++++++++++++++");
		System.out.println();
		Product prod1 = new Product("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL);
		System.out.println("Expected: Code: E0001 | Make: Zap Electronics | Model: Cool Chicken Mincer | Price: £99.99 | Department: Electrical | Quantity: 1");
		System.out.println("Outcome: " + prod1.toString());
		System.out.println();
		System.out.println("+++++++++++++++++++++++++ End of Test Case 1 ++++++++++++++++++++++++");
		System.out.println();
		System.out.println();
	}
	
	private static void testCase2() {
		System.out.println("++++++++++++++ Test Case 2: recordPurchase() TRUE Check +++++++++++++");
		System.out.println();
		Product prod1 = new Product("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL);
		System.out.println(prod1.toString());
		System.out.println("Recording purchases...");
		System.out.println("Expected: true");
		System.out.println("Outcome: " + prod1.recordPurchase("E0002", 1));
		System.out.println();
		System.out.println("+++++++++++++++++++++++++ End of Test Case 2 ++++++++++++++++++++++++");
		System.out.println();
		System.out.println();
	}
	
	private static void testCase3() {
		System.out.println("++++++++++++ Test Case 3: recordPurchase() FALSE Check ++++++++++++");
		System.out.println();
		Product prod1 = new Product("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL);
		System.out.println(prod1.toString());
		System.out.println("Recording purchases...");
		System.out.println("Expected: false");
		System.out.println("Outcome: " + prod1.recordPurchase("E0003", 3));
		System.out.println();
		System.out.println("++++++++++++++++++++++++ End of Test Case 3 +++++++++++++++++++++++");
		System.out.println();
		System.out.println();
	}
	
	private static void testCase4() {
		System.out.println("++++++++++++ Test Case 4: addToQuantity() - VALID INPUT ++++++++++++");
		System.out.println();
		Product prod1 = new Product("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL);
		System.out.println(prod1.toString());
		
		int amnt = 3;
		System.out.println("Adding Quantity by: " + amnt);
		prod1.addToQuantity(amnt);
		
		System.out.println("Expected: 4");
		System.out.println("Output: " + prod1.getQuantity());
		System.out.println();
		System.out.println("+++++++++++++++++++++++++ End of Test Case 4 +++++++++++++++++++++++");
		System.out.println();System.out.println();
	}
	
	private static void testCase5() {
		System.out.println("++++++++++++ Test Case 5: addToQuantity() - INVALID INPUT ++++++++++++");
		System.out.println();
		Product prod1 = new Product("Zap Electronics","Cool Chicken Mincer", 99.99, Department.ELECTRICAL, 2);
		System.out.println(prod1.toString());
		
		int amnt = -3;
		System.out.println("Adding Quantity by: " + amnt);
		prod1.addToQuantity(amnt);
		
		System.out.println("Expected: 2");
		System.out.println("Output: " + prod1.getQuantity());
		System.out.println();
		System.out.println("+++++++++++++++++++++++++ End of Test Case 5 +++++++++++++++++++++++++");
		System.out.println();System.out.println();
	}

}
