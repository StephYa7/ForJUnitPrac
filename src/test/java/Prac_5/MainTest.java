package Prac_5;

import Prac_5.number.MaxNumberModule;
import Prac_5.number.RandomNumberModule;
import Prac_5.user.UserRepository;
import Prac_5.user.UserService;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void testRandomListReturnLength() {
        List<Integer> test = RandomNumberModule.getRandomList(7);

        assertEquals(7, test.size());
        assertThat(test).hasSize(1).isNotEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    public void testRandomListReturnException(int value) {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomNumberModule.getRandomList(value);
        });
    }

    @Test
    public void testGetMaxNumberReturnMaxNumber() {
        List<Integer> testList = new ArrayList<>(Arrays.asList(-5, 10, 101));
        int resultTest = MaxNumberModule.getMaxNumber(testList);

        assertEquals(101, resultTest);
    }

    @Test
    public void testGetMaxNumberReturnException() {
        assertThrows(IllegalArgumentException.class, () -> {
            MaxNumberModule.getMaxNumber(new ArrayList<>());
        });
    }

    @Test
    public void testGetMaxNumberFromRandomListReturnNumber() {
        List<Integer> testList = RandomNumberModule.getRandomList(5);
        int result = MaxNumberModule.getMaxNumber(testList);

        assertEquals(Collections.max(testList), result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5})
    void integrationUserTest(int i) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String res = userService.getUserName(i);

        assertThat(res).isEqualTo("User " + i);
    }

}