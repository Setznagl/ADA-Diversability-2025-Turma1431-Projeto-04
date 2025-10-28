package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.gateway.PokeApiGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiGateway pokeApiGateway;

    @Autowired
    public PokemonServiceImpl(PokeApiGateway pokeApiGateway) {
        this.pokeApiGateway = pokeApiGateway;
    }

    @Cacheable("pokeApiTypeResponseDTO")
    public PokeApiTypeResponseDTO getPokemonsOfType(String type) {
        try {
            return pokeApiGateway.getPokemonOfType(type);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da PokeAPI: " + e.getMessage(), e);
        }
    }

    @CacheEvict(value = "pokeApiTypeResponseDTO", allEntries = true)
    public void cleanPokemonsByTypeCache() {
        System.out.println("Cache de pokemons por tipo foi limpo!");
    }
}
