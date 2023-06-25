package textExcel;

public class PercentCell implements Cell {
    private double value;

    public PercentCell(String text) {
        this.value = Double.parseDouble(text.substring(0, text.length() - 1)) / 100;
    }

    @Override
    public String fullCellText() {
        return value + "";
    }

    @Override
    public String abbreviatedCellText() {
        return Utils.fixedWidth((int) (value * 100) + "%");
    }
}
