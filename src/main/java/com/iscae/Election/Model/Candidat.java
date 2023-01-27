package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Candidat {
    private int id;
    private int fkEtudient;
    private int fkSyndicat;
    private Etudient etudientByFkEtudient;
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
    @Column(name = "FK_Etudient")
    public int getFkEtudient() {
        return fkEtudient;
    }

    public void setFkEtudient(int fkEtudient) {
        this.fkEtudient = fkEtudient;
    }

    @Basic
    @Column(name = "FK_Syndicat")
    public int getFkSyndicat() {
        return fkSyndicat;
    }

    public void setFkSyndicat(int fkSyndicat) {
        this.fkSyndicat = fkSyndicat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return id == candidat.id && fkEtudient == candidat.fkEtudient && fkSyndicat == candidat.fkSyndicat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fkEtudient, fkSyndicat);
    }

    @ManyToOne
    @JoinColumn(name = "FK_Etudient", referencedColumnName = "id", nullable = false)
    public Etudient getEtudientByFkEtudient() {
        return etudientByFkEtudient;
    }

    public void setEtudientByFkEtudient(Etudient etudientByFkEtudient) {
        this.etudientByFkEtudient = etudientByFkEtudient;
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
