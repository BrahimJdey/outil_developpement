package com.iscae.Election.crud.dtos;
import lombok.Data;
@Data
public class Election_SyndecatDto {
    private int id;
    private int FK_Election;
    private int FK_Syndicat;
    private int nombreElecteurs;

    public Election_SyndecatDto() {
    }

    public Election_SyndecatDto(int id, int FK_Election, int FK_Syndicat,int nombreElecteurs) {
        this.id = id;
        this.FK_Election = FK_Election;
        this.FK_Syndicat = FK_Syndicat;
        this.nombreElecteurs = nombreElecteurs;
    }
}
