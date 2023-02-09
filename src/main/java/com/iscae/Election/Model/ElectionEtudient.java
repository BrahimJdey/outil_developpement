package com.iscae.Election.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "election_etudient", schema = "election_db", catalog = "")
public class ElectionEtudient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "status", nullable = true)
    private Integer status;
    @Basic
    @Column(name = "FK_Etudient", nullable = true)
    private Integer fkEtudient;
    @Basic
    @Column(name = "FK_Election", nullable = true)
    private Integer fkElection;
    @ManyToOne
    @JoinColumn(name = "FK_Etudient", referencedColumnName = "id",insertable=false, updatable=false)
    private Etudient etudientByFkEtudient;
    @ManyToOne
    @JoinColumn(name = "FK_Election", referencedColumnName = "id",insertable=false, updatable=false)
    private Election electionByFkElection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getFkEtudient() {
        return fkEtudient;
    }

    public void setFkEtudient(Integer fkEtudient) {
        this.fkEtudient = fkEtudient;
    }

    public Integer getFkElection() {
        return fkElection;
    }

    public void setFkElection(Integer fkElection) {
        this.fkElection = fkElection;
    }

    public Etudient getEtudientByFkEtudient() {
        return etudientByFkEtudient;
    }

    public void setEtudientByFkEtudient(Etudient etudientByFkEtudient) {
        this.etudientByFkEtudient = etudientByFkEtudient;
    }

    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }
}
