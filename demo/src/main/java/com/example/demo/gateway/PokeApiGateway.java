package com.example.demo.gateway;

import com.example.demo.dto.PokeApiTypeResponseDTO;

public interface PokeApiGateway {

    public PokeApiTypeResponseDTO getPokemonOfType(String type);
}
