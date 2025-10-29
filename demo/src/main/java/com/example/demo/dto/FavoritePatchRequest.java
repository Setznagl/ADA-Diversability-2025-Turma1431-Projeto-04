package com.example.demo.dto;

// Se estiver usando Lombok para simplificar (o que é comum em Spring Boot):
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

// Use 'Boolean' (objeto) e não 'boolean' (primitivo)
// para que o campo possa ser nulo (null).
// Se o campo for nulo, o Service saberá que não deve atualizá-lo (atualização parcial).

@Data // Gera Getters, Setters, toString, hashCode, equals
@NoArgsConstructor // Construtor sem argumentos
@AllArgsConstructor // Construtor com todos os argumentos
public class FavoritePatchRequest {

    // O objeto Boolean é necessário para permitir que este campo seja opcional no JSON.
    private Boolean favorite;

    private String note;
}