package com.eddysdev;

import com.eddysdev.model.User;
import com.eddysdev.service.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserService userserv = new UserService();

        List<User> users = userserv.getUsers();

        for (User user : users) {
            System.out.printf(
                    """
                    User ID: %d
                    Name: %s
                    Email: %s
                    City: %s
                    Phone: %s%n
                    """,
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getAddress().getCity(),
                    user.getPhone()
            );
        }
    }
}