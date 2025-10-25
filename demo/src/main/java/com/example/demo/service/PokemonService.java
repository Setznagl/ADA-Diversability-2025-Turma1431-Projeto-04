package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    private HttpPokemonRequestService httpPokemonRequestService;

    public PokemonService(HttpPokemonRequestService httpPokemonRequestService) {
        this.httpPokemonRequestService = httpPokemonRequestService;
    }

    public PokeApiTypeResponseDTO getApi(String type) {
        try {
            String url = "https://pokeapi.co/api/v2/type/" + type;

            return httpPokemonRequestService.getPokemonType(url);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da PokeAPI: " + e.getMessage(), e);
        }
    }
}
