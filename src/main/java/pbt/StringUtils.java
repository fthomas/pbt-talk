package pbt;

public class StringUtils {

    public static String truncate(String s, int n) {
        if (n < 0) return "";
        if (s.length() <= n) return s;
        else return s.substring(0, n) + "...";
    }

}
