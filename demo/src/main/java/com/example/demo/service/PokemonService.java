package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.model.Pokemon;
import java.util.List;

public interface PokemonService {

    PokeApiTypeResponseDTO getPokemonsOfType(String type);

    void cleanPokemonsByTypeCache();

    Pokemon toggleFavorite(int id);

    List<Pokemon> getFavorites();

    Pokemon updateFavoriteAndNote(Long idLocal, Boolean favorite, String note);
}