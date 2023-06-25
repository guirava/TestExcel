package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
    private int row;
    private int col;

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    public SpreadsheetLocation(String cellName) {
        // cellName is made of a letter followed
        // by numbers: L20, D5, A3, G9, etc.
        // we need to split the 2:
        // 1. the letter
        // 2. the numbers
        // then convert the letter to a number
        // and subtract 1 from the number
        // to get the row and column
        String letter = cellName.substring(0, 1);
        String number = cellName.substring(1);
        row = Integer.parseInt(number) - 1;
        col = letter.toUpperCase().charAt(0) - 'A';
    }

}
