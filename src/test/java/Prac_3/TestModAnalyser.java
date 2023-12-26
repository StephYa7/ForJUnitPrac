package Prac_3;

import Prac_3.tdd.MoodAnalyser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestModAnalyser {
    @Test
    void analyserMoodReturnBad() {
        assertThat(MoodAnalyser.analyseMood("Hello M((")).isEqualTo("Bad");
    }

    @Test
    void analyserMoodReturnGood() {
        assertThat(MoodAnalyser.analyseMood(")) yep")).isEqualTo("Good");
    }

    @Test
    void analyserMoodReturnMedium() {
        assertThat(MoodAnalyser.analyseMood("i will return nothing")).isEqualTo("Medium");
    }
}