package com.eddysdev;

import com.google.gson.Gson;
import com.eddysdev.model.*;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/users"))
                .build();

        HttpResponse<String> response;

        try {
            response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        //System.out.println(json);

        Gson gson = new Gson();

        /*

        User[] users = gson.fromJson(json, User[].class);

        for (int i = 0; i < users.length; i++) {
            System.out.println(
                    "User name: "+ users[i].name
                    + "\nEmail: " + users[i].email
                    + '\n'
            );
        }

        */

        Type type = new TypeToken<List<User>>() {}.getType();

        List<User> users = gson.fromJson(json, type);

        for (User user : users) {
            System.out.printf("""
                    User ID: %d
                    Name: %s
                    Email: %s
                    City: %s
                    Phone: %s%n
                    """
                    , user.id, user.name, user.email, user.address.city, user.phone
            );
        }
    }
}