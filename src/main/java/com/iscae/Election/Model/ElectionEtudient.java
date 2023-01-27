package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "election_etudient", schema = "election_db", catalog = "")
public class ElectionEtudient {
    private int id;
    private Integer status;
    private Integer fkEtudient;
    private Integer fkElection;
    private Etudient etudientByFkEtudient;
    private Election electionByFkElection;

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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "FK_Etudient")
    public Integer getFkEtudient() {
        return fkEtudient;
    }

    public void setFkEtudient(Integer fkEtudient) {
        this.fkEtudient = fkEtudient;
    }

    @Basic
    @Column(name = "FK_Election")
    public Integer getFkElection() {
        return fkElection;
    }

    public void setFkElection(Integer fkElection) {
        this.fkElection = fkElection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectionEtudient that = (ElectionEtudient) o;
        return id == that.id && Objects.equals(status, that.status) && Objects.equals(fkEtudient, that.fkEtudient) && Objects.equals(fkElection, that.fkElection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, fkEtudient, fkElection);
    }

    @ManyToOne
    @JoinColumn(name = "FK_Etudient", referencedColumnName = "id")
    public Etudient getEtudientByFkEtudient() {
        return etudientByFkEtudient;
    }

    public void setEtudientByFkEtudient(Etudient etudientByFkEtudient) {
        this.etudientByFkEtudient = etudientByFkEtudient;
    }

    @ManyToOne
    @JoinColumn(name = "FK_Election", referencedColumnName = "id")
    public Election getElectionByFkElection() {
        return electionByFkElection;
    }

    public void setElectionByFkElection(Election electionByFkElection) {
        this.electionByFkElection = electionByFkElection;
    }
}
