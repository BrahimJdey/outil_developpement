package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "election_syndicat", schema = "election_db", catalog = "")
public class ElectionSyndicat {
    private int id;
    private Integer nombreElecteurs;
    private int fkElection;
    private int fkSyndicat;
    private Election electionByFkElection;
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
    @Column(name = "nombreElecteurs")
    public Integer getNombreElecteurs() {
        return nombreElecteurs;
    }

    public void setNombreElecteurs(Integer nombreElecteurs) {
        this.nombreElecteurs = nombreElecteurs;
    }

    @Basic
    @Column(name = "FK_Election")
    public int getFkElection() {
        return fkElection;
    }

    public void setFkElection(int fkElection) {
        this.fkElection = fkElection;
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
        ElectionSyndicat that = (ElectionSyndicat) o;
        return id == that.id && fkElection == that.fkElection && fkSyndicat == that.fkSyndicat && Objects.equals(nombreElecteurs, that.nombreElecteurs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreElecteurs, fkElection, fkSyndicat);
    }

    @ManyToOne
    @JoinColumn(name = "FK_Election", referencedColumnName = "id", nullable = false)
    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
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
