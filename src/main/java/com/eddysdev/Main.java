package com.eddysdev;

import com.google.gson.Gson;

class Usuario {

    String nombre;
    int edad;

    Usuario(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class Main {

    public static void main(String[] args) {

        Usuario usuario = new Usuario("Eddye", 25);

        Gson gson = new Gson();

        String json = gson.toJson(usuario);

        String metodo = """
                {
                    "nombre":"Eddys",
                    "edad":22
                }
                """;
        Usuario pruebametodo = gson.fromJson(metodo, Usuario.class);

        System.out.println(pruebametodo.nombre);
        System.out.println(pruebametodo.edad);
        System.out.println(metodo);

        System.out.println(json);
    }
}