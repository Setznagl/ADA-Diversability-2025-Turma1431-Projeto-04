package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

public interface PokemonService {

    @Cacheable("pokeApiTypeResponseDTO")
    public PokeApiTypeResponseDTO getPokemonsOfType(String type);

    @CacheEvict(value = "pokeApiTypeResponseDTO", allEntries = true)
    public void cleanPokemonsByTypeCache();
}
