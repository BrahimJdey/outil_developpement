package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Election {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "date_Debit", nullable = true, length = 100)
    private String dateDebit;
    @Basic
    @Column(name = "date_Fin", nullable = true, length = 100)
    private String dateFin;
    @Basic
    @Column(name = "sujet", nullable = true, length = 100)
    private String sujet;
    @OneToMany(mappedBy = "electionByFkElection")
    private Collection<ElectionEtudient> electionEtudientsById;
    @OneToMany(mappedBy = "electionByFkElection")
    private Collection<ElectionSyndicat> electionSyndicatsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDebit() {
        return dateDebit;
    }

    public void setDateDebit(String dateDebit) {
        this.dateDebit = dateDebit;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Collection<ElectionEtudient> getElectionEtudientsById() {
        return electionEtudientsById;
    }

    public void setElectionEtudientsById(Collection<ElectionEtudient> electionEtudientsById) {
        this.electionEtudientsById = electionEtudientsById;
    }

    public Collection<ElectionSyndicat> getElectionSyndicatsById() {
        return electionSyndicatsById;
    }

    public void setElectionSyndicatsById(Collection<ElectionSyndicat> electionSyndicatsById) {
        this.electionSyndicatsById = electionSyndicatsById;
    }
}
