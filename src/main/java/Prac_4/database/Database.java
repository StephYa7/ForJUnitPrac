package Prac_4.database;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<String> query(String sql) {
        // В реальной жизни здесь бы происходило обращение к базе данных.
        // Сейчас мы просто возвращаем фиктивные данные.
        List<String> fakeData = new ArrayList<>();
        fakeData.add("Data1");
        fakeData.add("Data2");
        fakeData.add("Data3");
        return fakeData;
    }
}