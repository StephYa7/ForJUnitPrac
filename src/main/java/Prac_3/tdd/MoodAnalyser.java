package Prac_3.tdd;

public class MoodAnalyser {

    public static String analyseMood(String message) {
        char[] messageCharsArray = message.toCharArray();
        int mood = 0;
        for (char messageChar : messageCharsArray) {
            if (messageChar == ')') mood++;
            else if (messageChar == '(') mood--;
        }
        if (mood > 0) return "Good";
        else if (mood < 0) return "Bad";
        return "Medium";
    }

}