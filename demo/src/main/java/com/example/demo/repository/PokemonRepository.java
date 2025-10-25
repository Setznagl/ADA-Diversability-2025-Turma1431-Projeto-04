package com.example.demo.repository;

import com.example.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByIdPokeApi(int idPokeApi);

    Optional<Pokemon> findByName(String name);

    Optional<Pokemon> findByNameIgnoreCase(String name);

    List<Pokemon> findByWeightGreaterThan(int weight);

    List<Pokemon> findByHeightGreaterThan(int height);

    List<Pokemon> findByFirstAbility(String ability);

    boolean existsByIdPokeApi(int idPokeApi);
}