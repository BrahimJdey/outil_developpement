package com.iscae.Election.crud.dtos;

import lombok.Data;
@Data

public class PosteDto {
        private int id;
        private String libelle;
        private int FK_Syndicat;
        private String description;

        public PosteDto(){}

    public PosteDto(int id, String libelle, int FK_Syndicat, String description) {
        this.id = id;
        this.libelle = libelle;
        this.FK_Syndicat = FK_Syndicat;
        this.description = description;
    }
}
