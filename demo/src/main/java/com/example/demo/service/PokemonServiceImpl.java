package com.example.demo.service;

import com.example.demo.dto.PokeApiTypeResponseDTO;
import com.example.demo.gateway.PokeApiGateway;
import com.example.demo.repository.PokemonRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Pokemon;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiGateway pokeApiGateway;
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonServiceImpl(PokeApiGateway pokeApiGateway, PokemonRepository pokemonRepository) {
        this.pokeApiGateway = pokeApiGateway;
        this.pokemonRepository = pokemonRepository;
    }

    // ➡️ IMPLEMENTAÇÃO CORRIGIDA DE CACHE E INTEGRAÇÃO (MÉTODO 1)
    @Override // ⬅️ Essencial para satisfazer a interface
    @Cacheable("pokeApiTypeResponseDTO")
    public PokeApiTypeResponseDTO getPokemonsOfType(String type) {
        try {
            // Assume que existe um método getPokemonOfType no Gateway
            return pokeApiGateway.getPokemonOfType(type);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar dados da PokeAPI: " + e.getMessage(), e);
        }
    }

    // ➡️ IMPLEMENTAÇÃO CORRIGIDA DE LIMPEZA DE CACHE (MÉTODO 2)
    @Override // ⬅️ Essencial para satisfazer a interface
    @CacheEvict(value = "pokeApiTypeResponseDTO", allEntries = true)
    public void cleanPokemonsByTypeCache() {
        // Implementação mínima para satisfazer a interface
        System.out.println("Cache de pokemons por tipo foi limpo!");
    }

    // -----------------------------------
    // MÉTODOS EXISTENTES
    // -----------------------------------

    @Override
    @Transactional // Adicionado para garantir a escrita
    public Pokemon toggleFavorite(int id) {
        Pokemon pokemon = pokemonRepository.findByIdPokeApi(id)
                .orElseThrow(() -> new RuntimeException("Pokemon não encontrado com ID: " + id));

        // Note: O isFavorite() e setFavorite() aqui devem ser os da Entidade
        pokemon.setFavorite(!pokemon.isFavorite());
        return pokemonRepository.save(pokemon);
    }

    @Override
    public List<Pokemon> getFavorites() {
        return pokemonRepository.findByFavoriteTrue();
    }


    // 🎯 IMPLEMENTAÇÃO DO PATCH /favorite (REQUISITO 5)
    @Override
    @Transactional
    public Pokemon updateFavoriteAndNote(Long idLocal, Boolean favorite, String note) {

        // 1. Busca o Pokémon no H2 pelo idLocal. Lança 404 se não existir.
        Pokemon pokemon = pokemonRepository.findById(idLocal)
                .orElseThrow(() -> new ResourceNotFoundException("Pokémon local não encontrado com ID: " + idLocal));

        // 2. Lógica de Atualização Parcial
        if (favorite != null) {
            pokemon.setFavorite(favorite);
        }
        if (note != null) {
            pokemon.setNote(note);
        }

        // 3. Salva (atualiza) e retorna
        return pokemonRepository.save(pokemon);
    }
}