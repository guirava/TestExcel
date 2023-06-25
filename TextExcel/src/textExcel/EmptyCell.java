package textExcel;

public class EmptyCell implements Cell {

    @Override
    public String fullCellText() {
        return "";
    }
    
    @Override
    public String abbreviatedCellText() {
        return Utils.fixedWidth("");
    }
}
