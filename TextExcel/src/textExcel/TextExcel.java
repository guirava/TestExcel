package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
		var sheet = new Spreadsheet();
		
		// start by printing the empty sheet
		System.out.println(sheet.getGridText());

		// input loop
		Scanner scanner = new Scanner(System.in);
		String input;
		while (true) {
			System.out.print("TextExcel> ");
			input = scanner.nextLine();
			if (input.trim().toLowerCase().equals("quit")) {
				break;
			}
			System.out.println(sheet.processCommand(input));
		}
		scanner.close();
	}
}
