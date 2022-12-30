package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Syndicat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "syndicat_type", nullable = true, length = 100)
    private String syndicatType;
    @Basic
    @Column(name = "syndicat_nom", nullable = true, length = 100)
    private String syndicatNom;
    @Basic
    @Column(name = "logo", nullable = true, length = 100)
    private String logo;
    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    private Collection<Candidat> candidatsById;
    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    private Collection<ElectionSyndicat> electionSyndicatsById;
    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    private Collection<Poste> postesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSyndicatType() {
        return syndicatType;
    }

    public void setSyndicatType(String syndicatType) {
        this.syndicatType = syndicatType;
    }

    public String getSyndicatNom() {
        return syndicatNom;
    }

    public void setSyndicatNom(String syndicatNom) {
        this.syndicatNom = syndicatNom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Collection<Candidat> getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Collection<Candidat> candidatsById) {
        this.candidatsById = candidatsById;
    }

    public Collection<ElectionSyndicat> getElectionSyndicatsById() {
        return electionSyndicatsById;
    }

    public void setElectionSyndicatsById(Collection<ElectionSyndicat> electionSyndicatsById) {
        this.electionSyndicatsById = electionSyndicatsById;
    }

    public Collection<Poste> getPostesById() {
        return postesById;
    }

    public void setPostesById(Collection<Poste> postesById) {
        this.postesById = postesById;
    }
}
