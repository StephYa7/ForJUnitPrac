package Prac_3;

import Prac_3.tdd.User;
import Prac_3.tdd.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUserRepository {
    UserRepository userRepository;

    @BeforeEach
    void options() {
        userRepository = new UserRepository();

        User user1 = new User("qwerty", "123456", true);
        User user2 = new User("qwert", "12345", true);
        User user3 = new User("qwer", "1234", false);
        User user4 = new User("qwe", "123", false);
        user1.setAuthenticate(true);
        user4.setAuthenticate(true);
        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
    }

    @Test
    void userRepositoryFoundUserIAuthenticate() {
        assertTrue(userRepository.findByName("qwerty"));
    }

    @Test
    void userRepositoryNotFoundUserIsNotAuthenticate() {
        assertFalse(userRepository.findByName("qwer"));
    }


    @Test
    void checkLogoutUserWithoutAdminRights() {

        userRepository.logOutAllUsersWithoutAdministratorRights();
        assertFalse(userRepository.findByName("qwe"));
    }

    @Test
    void checkLogoutAdminWithoutAdminRights() {

        userRepository.logOutAllUsersWithoutAdministratorRights();
        assertTrue(userRepository.findByName("qwerty"));
    }
}