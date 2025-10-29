package com.example.demo.controller;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.model.Pokemon;
import com.example.demo.service.PokemonService;
import com.example.demo.dto.FavoritePatchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

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

    @PatchMapping("/favorite/{id}")
    public ResponseEntity<Pokemon> toggleFavorite(@PathVariable int id) {
        try {
            Pokemon pokemon = pokemonService.toggleFavorite(id);
            return ResponseEntity.ok(pokemon);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Pokemon>> getFavorites() {
        return ResponseEntity.ok(pokemonService.getFavorites());
    }

    // 🎯 NOVO ENDPOINT (REQUISITO 5)
    @PatchMapping("/{idLocal}/favorite")
    public ResponseEntity<Pokemon> updateFavorite(
            @PathVariable Long idLocal, // Captura o ID do Pokémon da URL
            @RequestBody FavoritePatchRequest request) { // Captura o JSON para o DTO

        // 🛑 CHAMADA CORRIGIDA: Usa 'pokemonService'
        Pokemon updated = pokemonService.updateFavoriteAndNote(
                idLocal,
                request.getFavorite(), // Passa o valor de 'favorite' (pode ser null)
                request.getNote()       // Passa o valor de 'note' (pode ser null)
        );

        // Retorna a entidade atualizada com status HTTP 200 OK
        return ResponseEntity.ok(updated);
    }
}