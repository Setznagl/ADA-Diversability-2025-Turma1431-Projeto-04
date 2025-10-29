package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.gateway.PokeApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

public interface PokemonService {

    @Cacheable("pokeApiTypeResponseDTO")
    public PokeApiTypeResponseDTO getPokemonsOfType(String type);

    @CacheEvict(value = "pokeApiTypeResponseDTO", allEntries = true)
    public void cleanPokemonsByTypeCache();
}
