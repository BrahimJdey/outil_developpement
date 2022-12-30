package com.iscae.Election.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "election_syndicat", schema = "election_db", catalog = "")
public class ElectionSyndicat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombreElecteurs", nullable = true)
    private Integer nombreElecteurs;
    @Basic
    @Column(name = "FK_Election", nullable = false)
    private int fkElection;
    @Basic
    @Column(name = "FK_Syndicat", nullable = false)
    private int fkSyndicat;
    @ManyToOne
    @JoinColumn(name = "FK_Election", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Election electionByFkElection;
    @ManyToOne
    @JoinColumn(name = "FK_Syndicat", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Syndicat syndicatByFkSyndicat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNombreElecteurs() {
        return nombreElecteurs;
    }

    public void setNombreElecteurs(Integer nombreElecteurs) {
        this.nombreElecteurs = nombreElecteurs;
    }

    public int getFkElection() {
        return fkElection;
    }

    public void setFkElection(int fkElection) {
        this.fkElection = fkElection;
    }

    public int getFkSyndicat() {
        return fkSyndicat;
    }

    public void setFkSyndicat(int fkSyndicat) {
        this.fkSyndicat = fkSyndicat;
    }

    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }

    public Syndicat getSyndicatByFkSyndicat() {
        return syndicatByFkSyndicat;
    }

    public void setSyndicatByFkSyndicat(Syndicat syndicatByFkSyndicat) {
        this.syndicatByFkSyndicat = syndicatByFkSyndicat;
    }
}
