package Prac_4.weather;

import java.util.Random;

public class WeatherService {
    private Random random;

    public WeatherService() {
        this.random = new Random();
    }

    // Метод, который в реальной ситуации обращается к внешнему API для получения температуры
    public int getCurrentTemperature() {

        // Здесь обычно был бы код, который делает HTTP-запрос к внешнему API и возвращает температуру
        // Однако, поскольку это просто демонстрационный пример,
        // мы просто генерируем случайное значение температуры в диапазоне от 22 до 30.

        return 22 + random.nextInt(9);
    }

}