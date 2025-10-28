package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Setter
@Getter
public class PokeApiTypeResponseDTO implements Serializable {

    @JsonAlias("name")
    private String type;

    @JsonAlias("pokemon")
    private List<PokemonSlotDTO> result;

    @Setter
    @Getter
    public static class PokemonSlotDTO {
        private PokemonInfoDTO pokemon;

    }

    @Setter
    @Getter
    public static class PokemonInfoDTO {
        private String name;
        private String url;

    }
}
