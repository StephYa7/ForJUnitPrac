package Prac_4;

import java.util.List;

import static org.mockito.Mockito.mock;

public class Mockito {
    public static void main(String[] args) {

        List mockedList = mock(List.class);
        mockedList.add("1");
        System.out.println(mockedList);
        System.out.println(mockedList.get(0));
    }
}