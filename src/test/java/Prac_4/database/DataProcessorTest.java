package Prac_4.database;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DataProcessorTest {

    DataProcessor dataProcessor;
    Database databaseMock;
    String testSql;
    List<String> testData;


    @BeforeEach
    void setup() {
        testSql = "Test sql query";
        testData = List.of("1", "2", "3");
        databaseMock = mock(Database.class);
        dataProcessor = new DataProcessor(databaseMock);
    }

    @Test
    public void queryMethodInvokedOnce() {
        when(databaseMock.query(testSql)).thenReturn(testData);
        dataProcessor.processData(testSql);
        verify(databaseMock, times(1)).query(testSql);
    }

    @Test
    public void processDataMethodTest() {
        when(databaseMock.query(testSql)).thenReturn(testData);
        List<String> res = dataProcessor.processData(testSql);
        assertEquals(testData, res);
    }
}