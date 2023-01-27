package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Poste {
    private int id;
    private String libelle;
    private int fkSyndicat;
    private String description;
    private Syndicat syndicatByFkSyndicat;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Basic
    @Column(name = "FK_Syndicat")
    public int getFkSyndicat() {
        return fkSyndicat;
    }

    public void setFkSyndicat(int fkSyndicat) {
        this.fkSyndicat = fkSyndicat;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poste poste = (Poste) o;
        return id == poste.id && fkSyndicat == poste.fkSyndicat && Objects.equals(libelle, poste.libelle) && Objects.equals(description, poste.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, fkSyndicat, description);
    }

    @ManyToOne
    @JoinColumn(name = "FK_Syndicat", referencedColumnName = "id", nullable = false)
    public Syndicat getSyndicatByFkSyndicat() {
        return syndicatByFkSyndicat;
    }

    public void setSyndicatByFkSyndicat(Syndicat syndicatByFkSyndicat) {
        this.syndicatByFkSyndicat = syndicatByFkSyndicat;
    }
}
