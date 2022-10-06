package part03;

import java.awt.*;

import console.Console;

/**
 * @author Chelsea De Marseilla
 * Student ID: 40329124
 */
public class ConsoleMenu extends Console{
	private String title;
	private String items[];

	public ConsoleMenu(String title, String options[]) {
		super(true);
		setSize(900,500);
		setVisible(true);
		setBgColour(Color.black);
		setFont(new Font("Courier", Font.BOLD, 15));
		setColour(Color.white);
		
		this.title = title;
		items = options;
	}

	private void display() {
		println(title);
		for (int i = 0; i < title.length(); i++) {
			print("+");
		}
		println();
		for (int opt = 1; opt <= items.length; opt++) {
			println(opt + ". " + items[opt - 1]);
		}
		println();
	}

	public int getUserChoice() {
		int select = 0;
		//display();
		do {
			try {	
				display();
				print("Enter Selection: ");
				String value = readLn();
				select = Integer.parseInt(value);
				break;
			}
			catch(Exception ex) {
				System.out.println("Invalid menu option - try again!");
				readLn();
			}
			
		} while (true);
		return select;
	}

}
