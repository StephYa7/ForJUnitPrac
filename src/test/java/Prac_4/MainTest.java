package Prac_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.*;

class MainTest {

    @Test
    public void simpleTest() {
        List<String> mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void iteratorWillReturnHelloWorld() {
        Iterator iteratorMock = mock(Iterator.class);
        when(iteratorMock.next()).thenReturn("Hello", "World");
        String result = iteratorMock.next() + " " + iteratorMock.next();
        assertEquals("Hello World", result);
    }

}