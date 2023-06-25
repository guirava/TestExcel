package textExcel;

import java.net.PasswordAuthentication;

// Update this file with your own code.

public class Spreadsheet implements Grid {
	public static final int ROWS = 20;
	public static final int COLS = 12;
	Cell[][] sheet; // = new Cell[ROWS][COLS];

	public Spreadsheet() {
		sheet = new Cell[ROWS][COLS];
		Clear();
	}

	public void Clear() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				sheet[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command) {
		command = command.trim();
		if (command == "") {
			return "";
		}
		// if there's a '=' sign, it's an assignment
		if (command.contains("=")) {
			// split the command into two parts
			String[] parts = command.split("=", 2);
			// the first part is the location
			SpreadsheetLocation loc = new SpreadsheetLocation(parts[0].trim());
			// the second part is the value
			String value = parts[1].trim();

			// if value is wrapped in double quotes -> TextCell
			if (value.startsWith("\"") && value.endsWith("\"")) {
				// remove the quotes
				value = value.substring(1, value.length() - 1);
				// assign the value to the location
				sheet[loc.getRow()][loc.getCol()] = new TextCell(value);
				return getGridText();
			}

			// if value ends with a '%' -> PercentCell
			if (value.endsWith("%")) {
				// assign the value to the location
				sheet[loc.getRow()][loc.getCol()] = new PercentCell(value);
				return getGridText();
			}

			// try to parse the value as a double
			try {
				// assign the value to the location
				sheet[loc.getRow()][loc.getCol()] = new RealCell(value);
				return getGridText();
			} catch (Exception e) {
				// if it fails, return an error message
				return "Invalid value: " + value;
			}

		}

		// if command is "clear", clear the sheet
		if (command.equalsIgnoreCase("clear")) {
			Clear();
			return getGridText();
		}

		// if command is "clear" followed by a cell location, clear that cell
		if (command.toLowerCase().startsWith("clear ")) {
			// get the location
			SpreadsheetLocation loc = new SpreadsheetLocation(command.substring(6).trim());
			// clear the cell
			sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
			return getGridText();
		}

		// try to see if it's just a cell location:
		if (command.matches("^[a-zA-Z]+[0-9]+$")) {
			try {
				SpreadsheetLocation loc = new SpreadsheetLocation(command);
				return getCell(loc).fullCellText();
			} catch (Exception e) {
				return "Invalid cell location: " + command;
			}
		}
		return "NOT IMPLEMENTED";
	}

	@Override
	public int getRows() {
		return ROWS;
	}

	@Override
	public int getCols() {
		return COLS;
	}

	@Override
	public Cell getCell(Location loc) {
		return sheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		String grid = "   |";
		for (int i = 0; i < COLS; i++) {
			grid += (char) ('A' + i) + "         |";
		}
		grid += "\n";
		for (int i = 0; i < ROWS; i++) {
			if (i < 9) { // for 1-9 add two spaces
				grid += (i + 1) + "  |";
			} else { // for 10 and above add one space
				grid += (i + 1) + " |";
			}
			for (int j = 0; j < COLS; j++) {
				grid += sheet[i][j].abbreviatedCellText() + "|";
			}
			grid += "\n";
		}
		return grid;
	}

}
