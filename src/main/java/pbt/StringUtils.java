package pbt;

public class StringUtils {

    public static String truncate(String s, int n) {
        if (s.length() <= n) return s;
        else return s.substring(0, n) + "...";
    }

}
