package com.iscae.Election.crud.dtos;
import lombok.Data;
@Data
public class SyndicatDto {
    private int id;
    private String syndicat_type;
    private String syndicat_nom;
    private String logo;

    public SyndicatDto() {
    }

    public SyndicatDto(int id, String syndicat_type, String syndicat_nom, String logo) {
        this.id = id;
        this.syndicat_type = syndicat_type;
        this.syndicat_nom = syndicat_nom;
        this.logo = logo;
    }
}
