package com.example.multipledatasources.segundoBanco.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private Produto(){}
}
