package textExcel;

public class Utils {

    public static String fixedWidth(String s) {
        return String.format(String.format("%%-%d.%ds", 10, 10), s);
    }
}
