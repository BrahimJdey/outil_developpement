package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Etudient {
    private int id;
    private int ine;
    private String nom;
    private String prenom;
    private String date;
    private String email;
    private String password;
    private String inscription;
    private String niveau;
    private String etablisement;
    private Collection<Candidat> candidatsById;
    private Collection<ElectionEtudient> electionEtudientsById;

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
    @Column(name = "INE")
    public int getIne() {
        return ine;
    }

    public void setIne(int ine) {
        this.ine = ine;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "inscription")
    public String getInscription() {
        return inscription;
    }

    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    @Basic
    @Column(name = "niveau")
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Basic
    @Column(name = "etablisement")
    public String getEtablisement() {
        return etablisement;
    }

    public void setEtablisement(String etablisement) {
        this.etablisement = etablisement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudient etudient = (Etudient) o;
        return id == etudient.id && ine == etudient.ine && Objects.equals(nom, etudient.nom) && Objects.equals(prenom, etudient.prenom) && Objects.equals(date, etudient.date) && Objects.equals(email, etudient.email) && Objects.equals(password, etudient.password) && Objects.equals(inscription, etudient.inscription) && Objects.equals(niveau, etudient.niveau) && Objects.equals(etablisement, etudient.etablisement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ine, nom, prenom, date, email, password, inscription, niveau, etablisement);
    }

    @OneToMany(mappedBy = "etudientByFkEtudient")
    public Collection<Candidat> getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Collection<Candidat> candidatsById) {
        this.candidatsById = candidatsById;
    }

    @OneToMany(mappedBy = "etudientByFkEtudient")
    public Collection<ElectionEtudient> getElectionEtudientsById() {
        return electionEtudientsById;
    }

    public void setElectionEtudientsById(Collection<ElectionEtudient> electionEtudientsById) {
        this.electionEtudientsById = electionEtudientsById;
    }
}
