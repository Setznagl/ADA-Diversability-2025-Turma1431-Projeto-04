package com.example.demo.gateway;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

public interface PokeApiGateway {

    public PokeApiTypeResponseDTO getPokemonOfType(String type);
}
