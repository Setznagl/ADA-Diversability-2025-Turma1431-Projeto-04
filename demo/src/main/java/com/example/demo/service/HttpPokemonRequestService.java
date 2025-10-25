package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpPokemonRequestService {

    private final RestTemplate restTemplate;

    public HttpPokemonRequestService() {
        this.restTemplate = new RestTemplate();
    }

    public PokeApiTypeResponseDTO getPokemonType(String url) {
        return restTemplate.getForObject(url, PokeApiTypeResponseDTO.class);
    }
}
