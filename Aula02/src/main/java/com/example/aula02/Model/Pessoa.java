package com.example.aula02.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Aula02Pessoa")
public class Pessoa {

    @Id
    private Long id;

    @Column(unique = false, length = 10, nullable = false)
    private String nome;

    @Column(unique = false, length = 3, nullable = false)
    private int idade;

}
