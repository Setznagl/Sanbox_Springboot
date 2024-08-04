package com.example.aula02.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

//Anotações do Lombok e JPA
@Data
@Entity
public class Pessoa {

    @Id
    private Long id;

    @Column(length = 10, nullable = false)
    private String nome;

    @Column(length = 3, nullable = false)
    private int idade;

}
