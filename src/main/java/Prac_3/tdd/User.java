package Prac_3.tdd;

import lombok.Data;

@Data
public class User {
    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean authenticate(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password)) {
            this.isAuthenticate = true;
            return true;
        }
        this.isAuthenticate = false;
        return false;
    }

//    public boolean logout(String name, String password) {
//        if (this.name.equals(name) && this.password.equals(password)) {
//            this.isAuthenticate = false;
//            return true;
//        }
//        this.isAuthenticate = false;
//        return false;
//    }
}