package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Election {
    private int id;
    private String dateDebit;
    private String dateFin;
    private String sujet;
    private Collection<ElectionEtudient> electionEtudientsById;
    private Collection<ElectionSyndicat> electionSyndicatsById;

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
    @Column(name = "date_Debit")
    public String getDateDebit() {
        return dateDebit;
    }

    public void setDateDebit(String dateDebit) {
        this.dateDebit = dateDebit;
    }

    @Basic
    @Column(name = "date_Fin")
    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    @Basic
    @Column(name = "sujet")
    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Election election = (Election) o;
        return id == election.id && Objects.equals(dateDebit, election.dateDebit) && Objects.equals(dateFin, election.dateFin) && Objects.equals(sujet, election.sujet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateDebit, dateFin, sujet);
    }

    @OneToMany(mappedBy = "electionByFkElection")
    public Collection<ElectionEtudient> getElectionEtudientsById() {
        return electionEtudientsById;
    }

    public void setElectionEtudientsById(Collection<ElectionEtudient> electionEtudientsById) {
        this.electionEtudientsById = electionEtudientsById;
    }

    @OneToMany(mappedBy = "electionByFkElection")
    public Collection<ElectionSyndicat> getElectionSyndicatsById() {
        return electionSyndicatsById;
    }

    public void setElectionSyndicatsById(Collection<ElectionSyndicat> electionSyndicatsById) {
        this.electionSyndicatsById = electionSyndicatsById;
    }
}
