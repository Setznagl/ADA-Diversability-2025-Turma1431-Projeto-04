package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.gateway.PokeApiGateway;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private final PokeApiGateway pokeApiGateway;

    public PokemonService(PokeApiGateway pokeApiGateway) {
        this.pokeApiGateway = pokeApiGateway;
    }

    public PokeApiTypeResponseDTO getPokemonOfType(String type) {
        try {
            return pokeApiGateway.getPokemonOfType(type);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da PokeAPI: " + e.getMessage(), e);
        }
    }
}
