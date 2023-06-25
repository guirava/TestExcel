package textExcel;

public class TextCell implements Cell {
    private String text;

    public TextCell(String text) {
        this.text = text;
    }

    @Override
    public String abbreviatedCellText() {
        String abbreviatedText = text;
        if (text.length() > 10) {
            abbreviatedText = text.substring(0, 10);
        } else {
            for (int i = text.length(); i < 10; i++) {
                abbreviatedText += " ";
            }
        }
        return abbreviatedText;
    }

    @Override
    public String fullCellText() {
        return "\"" + text + "\"";
    }
}
