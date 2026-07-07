package com.eddysdev.service;

import com.eddysdev.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class UserService {

    private final Gson gson = new Gson();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private final HttpClient client = HttpClient.newHttpClient();

    public List<User> getUsers() {

        return parseUsers(getJson(BASE_URL + "/users/"));
    }

    public User getUserById(int id) {

        return gson.fromJson(getJson(BASE_URL + "/users/" + id), User.class);
    }

    private String getJson(String url) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
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

        return response.body();
    }

    private List<User> parseUsers(String json) {

        return gson.fromJson(json, new TypeToken<List<User>>() {
        }.getType());
    }
}