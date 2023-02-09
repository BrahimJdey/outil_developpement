package com.iscae.Election.crud.dtos;
import lombok.Data;
@Data
public class Candidat_Dto {
    private int id;
    private int FK_Etudient;
    private int FK_Syndicat;

    public Candidat_Dto() {
    }

    public Candidat_Dto(int id, int FK_Etudient, int FK_Syndicat) {
        this.id = id;
        this.FK_Etudient = FK_Etudient;
        this.FK_Syndicat = FK_Syndicat;
    }
}
