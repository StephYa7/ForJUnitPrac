package Prac_3.tdd;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserRepository {

    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutAllUsersWithoutAdministratorRights() {
        for (User user : data) {
            if (!user.isAdmin() && !user.isAuthenticate()) {
                user.setAuthenticate(false);
            }
        }
    }
}