package com.example.demo.repository;

import com.example.demo.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByIdPokeApi(int idPokeApi);

    Optional<Pokemon> findByName(String name);

    Optional<Pokemon> findByNameIgnoreCase(String name);

    List<Pokemon> findByFavoriteTrue();

    @Query("SELECT p FROM Pokemon p WHERE p.types LIKE %:type%")
    List<Pokemon> findByType(@Param("type") String type);

    List<Pokemon> findByWeightGreaterThan(int weight);

    List<Pokemon> findByHeightGreaterThan(int height);

    List<Pokemon> findByFirstAbility(String ability);

    @Query("SELECT p FROM Pokemon p WHERE p.note IS NOT NULL AND p.note != ''")
    List<Pokemon> findPokemonsWithNotes();

    @Query("SELECT p FROM Pokemon p WHERE p.favorite = true AND p.note IS NOT NULL")
    List<Pokemon> findFavoritesWithNotes();

    boolean existsByIdPokeApi(int idPokeApi);
}