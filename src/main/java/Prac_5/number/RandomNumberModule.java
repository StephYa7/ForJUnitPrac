package Prac_5.number;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumberModule {
    public static ArrayList<Integer> getRandomList(int length) {
        if (length < 1) throw new IllegalArgumentException();
        ArrayList<Integer> randomList = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomList.add(random.nextInt(101));
        }
        return randomList;
    }
}