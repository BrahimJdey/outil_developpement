package com.iscae.springProject.Dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String username;

    private String nom;

    private String prenom;

    private long telephone;

    private String email;

    private String password;

    public UserDto(Long id, String username, String nom, String prenom, long telephone, String email, String password) {
        this.id = id;
        this.username = username;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }
}
