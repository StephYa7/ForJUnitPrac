package Prac_3;

import Prac_3.tdd.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    void options() {
        user = new User("qwerty", "12345", false);
    }

    @Test
    void failedNameInAuthenticate() {
        assertFalse(user.authenticate("qwert", "12345"));
    }

    @Test
    void failedPasswordInAuthenticate() {
        assertFalse(user.authenticate("qwerty", "1234"));
    }

    @Test
    void failedNameAndPasswordInAuthenticate() {
        assertFalse(user.authenticate("qwer", "123"));
    }

    @Test
    void completedAuthenticate() {
        assertTrue(user.authenticate("qwerty", "12345"));
    }


}