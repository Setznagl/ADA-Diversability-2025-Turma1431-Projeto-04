package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocal;

    private int idPokeApi;

    private String name;

    private int height;

    private int weight;

    private String firstAbility;

    private String types; // CSV simples

    private LocalDateTime cachedAt;

    private boolean favorite;

    private String note;

    // Construtores
    public Pokemon() {}

    public Pokemon(int idPokeApi, String name, int height, int weight,
                   String firstAbility, String types) {
        this.idPokeApi = idPokeApi;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.firstAbility = firstAbility;
        this.types = types;
        this.cachedAt = LocalDateTime.now();
        this.favorite = false;
    }

    // Getters e Setters
    public Long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Long idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdPokeApi() {
        return idPokeApi;
    }

    public void setIdPokeApi(int idPokeApi) {
        this.idPokeApi = idPokeApi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getFirstAbility() {
        return firstAbility;
    }

    public void setFirstAbility(String firstAbility) {
        this.firstAbility = firstAbility;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public LocalDateTime getCachedAt() {
        return cachedAt;
    }

    public void setCachedAt(LocalDateTime cachedAt) {
        this.cachedAt = cachedAt;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}