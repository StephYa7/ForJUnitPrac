package Prac_5.number;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxNumberModule {

    public static int getMaxNumber(List<Integer> inputList) {
        if (inputList.size() < 1) throw new IllegalArgumentException();
        return inputList.stream().max(Comparator.comparingInt(o -> o)).get();
    }
}
//      return RandomNumberModule.getRandomList(length).stream().max(Comparator.comparingInt(o->o)).get();