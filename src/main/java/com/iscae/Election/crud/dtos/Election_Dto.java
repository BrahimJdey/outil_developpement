package com.iscae.Election.crud.dtos;
import lombok.Data;
@Data
public class Election_Dto {
    private int id;
    private String date_Debit;
    private String date_Fin;
    private String sujet;

    public Election_Dto() {
    }

    public Election_Dto(int id, String date_Debit, String date_Fin, String sujet) {
        this.id = id;
        this.date_Debit = date_Debit;
        this.date_Fin = date_Fin;
        this.sujet = sujet;
    }
}
