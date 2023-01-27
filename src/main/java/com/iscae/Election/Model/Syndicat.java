package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Syndicat {
    private int id;
    private String syndicatType;
    private String syndicatNom;
    private String logo;
    private Collection<Candidat> candidatsById;
    private Collection<ElectionSyndicat> electionSyndicatsById;
    private Collection<Poste> postesById;

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
    @Column(name = "syndicat_type")
    public String getSyndicatType() {
        return syndicatType;
    }

    public void setSyndicatType(String syndicatType) {
        this.syndicatType = syndicatType;
    }

    @Basic
    @Column(name = "syndicat_nom")
    public String getSyndicatNom() {
        return syndicatNom;
    }

    public void setSyndicatNom(String syndicatNom) {
        this.syndicatNom = syndicatNom;
    }

    @Basic
    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Syndicat syndicat = (Syndicat) o;
        return id == syndicat.id && Objects.equals(syndicatType, syndicat.syndicatType) && Objects.equals(syndicatNom, syndicat.syndicatNom) && Objects.equals(logo, syndicat.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, syndicatType, syndicatNom, logo);
    }

    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    public Collection<Candidat> getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Collection<Candidat> candidatsById) {
        this.candidatsById = candidatsById;
    }

    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    public Collection<ElectionSyndicat> getElectionSyndicatsById() {
        return electionSyndicatsById;
    }

    public void setElectionSyndicatsById(Collection<ElectionSyndicat> electionSyndicatsById) {
        this.electionSyndicatsById = electionSyndicatsById;
    }

    @OneToMany(mappedBy = "syndicatByFkSyndicat")
    public Collection<Poste> getPostesById() {
        return postesById;
    }

    public void setPostesById(Collection<Poste> postesById) {
        this.postesById = postesById;
    }
}
