package com.iscae.Election.crud.dtos;
import lombok.Data;
@Data
public class ElectionEtudient_Dto {
    private int id;
    private int status;
    private int FK_Etudient;
    private int FK_Election;

    public ElectionEtudient_Dto() {
    }

    public ElectionEtudient_Dto(int id, int status, int FK_Etudient, int FK_Election) {
        this.id = id;
        this.status = status;
        this.FK_Etudient = FK_Etudient;
        this.FK_Election = FK_Election;
    }
}
