package Prac_4.weather;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {
    @Test
    void generateReportTest(){
        WeatherService mockWeatherService = mock(WeatherService.class);
        when(mockWeatherService.getCurrentTemperature()).thenReturn(25);
        WeatherReporter weatherReporter = new WeatherReporter(mockWeatherService);

        String reply = weatherReporter.generateReport();

        assertThat(reply).isEqualTo("Текущая температура: " + 25 + " градусов.");
    }


}