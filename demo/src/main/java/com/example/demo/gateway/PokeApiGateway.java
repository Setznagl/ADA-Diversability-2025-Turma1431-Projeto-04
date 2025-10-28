package com.example.demo.gateway;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiGateway {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "https://pokeapi.co/api/v2/type/";

    public PokeApiTypeResponseDTO getPokemonOfType(String type) {
        String url = BASE_URL + type;

        return restTemplate.getForObject(url, PokeApiTypeResponseDTO.class);
    }
}
