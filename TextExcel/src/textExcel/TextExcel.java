package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
		// Add your command loop here
		Scanner scanner = new Scanner(System.in);
		String input;
		while (true) {
			System.out.print("TextExcel> ");
			input = scanner.nextLine();
			if (input.toLowerCase().equals("quit")) {
				break;
			}
			System.out.println(processInput(input));
		}
		scanner.close();
	}

	public static String processInput(String input) {
		return "NOT IMPLEMENTED";
	}
}
