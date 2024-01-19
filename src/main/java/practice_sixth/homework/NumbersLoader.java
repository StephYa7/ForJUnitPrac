package practice_sixth.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersLoader {
    private NumbersLoader() {
        throw new IllegalStateException("Utility class");
    }

    public static List<Integer> loadArraysFromFile(String fileName) {
        List<Integer> result = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ) {
            String input = buffer.readLine();
            String[] arrayStringNumbers = input.trim().split(" ");
            Arrays.stream(arrayStringNumbers).forEach(o -> result.add(Integer.valueOf(o)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}