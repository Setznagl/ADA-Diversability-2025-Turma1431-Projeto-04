package com.example.demo.controller;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    
    @GetMapping("/type/{type}")
    public ResponseEntity<PokeApiTypeResponseDTO> getByTypeFromApi(@PathVariable String type) {
        PokeApiTypeResponseDTO response = pokemonService.getPokemonsOfType(type);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/type/cache")
    public ResponseEntity<Void> cleanPokemonByTypeCache() {
        pokemonService.cleanPokemonsByTypeCache();
        return ResponseEntity.noContent().build();
    }
}
