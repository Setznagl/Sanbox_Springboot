package com.example.javadocker.Model;

import jakarta.persistence.*;

@Entity
public class SysUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}



    @Column(nullable = false)
    private String username;
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
}
