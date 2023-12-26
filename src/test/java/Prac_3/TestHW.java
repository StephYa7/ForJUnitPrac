package Prac_3;

import Prac_3.hw.MainHW;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHW {
    @ParameterizedTest
    @ValueSource(ints = {1, 5, -133})
    void evenReturnFalse(int i) {
        assertFalse(MainHW.evenOddNumber(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 122, -1024})
    void evenReturnTrue(int i) {
        assertTrue(MainHW.evenOddNumber(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {26,60, 99})
    void numberInIntervalReturnTrue(int i) {
        assertTrue(MainHW.numberInInterval(i));
    }
    @ParameterizedTest
    @ValueSource(ints = {-1,25,100})
    void numberInIntervalReturnFalse(int i) {
        assertFalse(MainHW.numberInInterval(i));
    }
}