package Prac_3.hw;

public class MainHW {
    public static boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numberInInterval(int n) {
        if (n > 25 && n < 100) {
            return true;
        }
        return false;
    }
}