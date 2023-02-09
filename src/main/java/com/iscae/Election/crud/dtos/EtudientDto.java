package com.iscae.Election.crud.dtos;

import lombok.Data;
@Data
public class EtudientDto
{
   private int id;
   private int ine;
   private String nom;
   private String prenom;
   private String date;
   private String email;
   private String password;
   private String inscription;
   private String niveau;
   private String etablisement;

   public EtudientDto() {
   }

   public EtudientDto(int id, int INE, String nom, String prenom, String date,
                      String email, String password, String inscription,
                      String niveau, String etablisement) {
      this.id = id;
      this.ine = INE;
      this.nom = nom;
      this.prenom = prenom;
      this.date = date;
      this.email = email;
      this.password = password;
      this.inscription = inscription;
      this.niveau = niveau;
      this.etablisement = etablisement;
   }
}
