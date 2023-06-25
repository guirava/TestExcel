package textExcel;

public class RealCell implements Cell{
    private double value;
    public RealCell(String text) {
        this.value = Double.parseDouble(text);
    }

    @Override
    public String fullCellText() {
        return value + "";
    }

    @Override
    public String abbreviatedCellText() {
        return Utils.fixedWidth(value + "");
    }
}
