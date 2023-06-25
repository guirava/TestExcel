package textExcel;

public class TextCell implements Cell {
    private String text;

    public TextCell(String text) {
        this.text = text;
    }

    @Override
    public String fullCellText() {
        return "\"" + text + "\"";
    }

    @Override
    public String abbreviatedCellText() {
        return Utils.fixedWidth(text);
    }
}
