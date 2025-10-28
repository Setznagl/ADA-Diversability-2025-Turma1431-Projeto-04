package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

  @Id
  @JsonProperty("id")
  private int idPokeApi;

  @NotNull(message = "O nome não pode ser nulo")
  private String name;
  @Positive(message = "A altura deve ser positiva")
  private int height;
  @Positive(message = "O peso deve ser positivo")
  private int weight;

  private String firstAbility;
  private List<String> types;

  @JsonProperty("abilities")
  private void unpackAbilities(List<AbilityWrapper> abilities) {
    if (abilities != null && !abilities.isEmpty()) {
      this.firstAbility = abilities.get(0).getAbility().getName();
    }
  }

  @JsonProperty("types")
  private void unpackTypes(List<TypeWrapper> types) {
    if (types != null) {
      this.types = types.stream()
        .map(t -> t.getType().getName())
        .collect(Collectors.toList());
    }
  }

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class AbilityWrapper {
    private Ability ability;
  }

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Ability {
    private String name;
  }

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class TypeWrapper {
    private Type type;
  }

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Type {
    private String name;
  }
}