package Prac_5.number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxNumberModule {

    public static int getMaxNumber(List<Integer> inputList) {
        if (inputList.size() < 1 || inputList == null) throw new IllegalArgumentException();
        int max = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            if (max < inputList.get(i)) max = inputList.get(i);
        }
        return max;
    }
}