package com.example.demo.gateway;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiGateway {

    private final RestTemplate restTemplate;

    public PokeApiGateway() {
        this.restTemplate = new RestTemplate();
    }

    public PokeApiTypeResponseDTO getPokemonOfType(String type) {
        String url = "https://pokeapi.co/api/v2/type/" + type;

        return restTemplate.getForObject(url, PokeApiTypeResponseDTO.class);
    }
}
