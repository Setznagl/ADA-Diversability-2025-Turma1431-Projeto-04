package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Setter
@Getter
public class PokeApiTypeResponseDTO {

    private String name;
    private List<PokemonSlotDTO> pokemon;

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
