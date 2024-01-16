package Prac_6.HW;


import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MyList {
    private List<Integer> list;


    public int getAverageNumber() {
        int average = 0;
        for (int i = 0; i < list.size(); i++) {
            average += list.get(i);
        }
        average = average / list.size();
        return average;
    }
}