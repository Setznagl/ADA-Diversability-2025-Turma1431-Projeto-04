package com.example.demo.gateway;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Primary
public class PokeApiGatewayImpl implements PokeApiGateway {

    private final RestTemplate restTemplate;

    @Autowired
    public PokeApiGatewayImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String BASE_URL = "https://pokeapi.co/api/v2/type/";

    public PokeApiTypeResponseDTO getPokemonOfType(String type) {
        String url = BASE_URL + type;

        return restTemplate.getForObject(url, PokeApiTypeResponseDTO.class);
    }
}
