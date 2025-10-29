package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.gateway.PokeApiGateway;
import com.example.demo.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.example.demo.model.Pokemon;
import java.util.List;
import com.example.demo.repository.PokemonRepository;


public interface PokemonService {
    public Pokemon updateFavoriteAndNote(Long idLocal, Boolean favorite, String note);

    @Cacheable("pokeApiTypeResponseDTO")
    public PokeApiTypeResponseDTO getPokemonsOfType(String type);

    @CacheEvict(value = "pokeApiTypeResponseDTO", allEntries = true)
    public void cleanPokemonsByTypeCache();
    Pokemon toggleFavorite(int id);
    List<Pokemon> getFavorites();


}
