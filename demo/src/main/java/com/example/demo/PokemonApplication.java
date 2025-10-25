package com.example.demo;

import com.example.demo.model.Pokemon;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class PokemonApplication {
    public static void main(String[] args) {
      String urlString = "https://pokeapi.co/api/v2/pokemon/pikachu";

      try {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        int status = connection.getResponseCode();
        if (status == 200) {
          BufferedReader reader = new BufferedReader (
            new InputStreamReader (connection.getInputStream())
          );

          StringBuilder responseBuilder = new StringBuilder();
          String line;
          while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
          }
          reader.close();

          ObjectMapper mapper = new ObjectMapper();
          Pokemon pikachu = mapper.readValue(responseBuilder.toString(), Pokemon.class);

          System.out.println("ID: " + pikachu.getIdPokeApi());
          System.out.println("Name: " + pikachu.getName());
          System.out.println("Height: " + pikachu.getHeight());
          System.out.println("Weight: " + pikachu.getWeight());
          System.out.println("First Ability: " + pikachu.getFirstAbility());
          System.out.println("Types: " + pikachu.getTypes());
        } else {
          System.out.println("Erro na requisição: " + status);
        }

        connection.disconnect();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
}


