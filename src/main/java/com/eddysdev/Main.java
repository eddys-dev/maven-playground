package com.eddysdev;

import com.eddysdev.model.User;
import com.eddysdev.service.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        printUserById();
    }

    private static void printAllUsers(){

        List<User> users = service.getUsers();

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

    private static void printUserById(){

        int id = 5;

        User user = service.getUserById(id);

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

    private static final UserService service = new UserService();
}