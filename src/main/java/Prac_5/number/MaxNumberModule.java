package Prac_5.number;

import java.util.Comparator;
import java.util.List;

public class MaxNumberModule {

    public static int getMaxNumber(List<Integer> inputList) {
        return inputList.stream().max(Comparator.comparingInt(o -> o)).get();
    }
}
//      return RandomNumberModule.getRandomList(length).stream().max(Comparator.comparingInt(o->o)).get();