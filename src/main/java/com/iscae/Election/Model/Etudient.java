package com.iscae.Election.Model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Etudient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "INE", nullable = false)
    private int ine;
    @Basic
    @Column(name = "nom", nullable = false, length = 30)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 30)
    private String prenom;
    @Basic
    @Column(name = "date", nullable = false, length = 100)
    private String date;
    @Basic
    @Column(name = "email", nullable = false, length = 100)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "inscription", nullable = false, length = 15)
    private String inscription;
    @Basic
    @Column(name = "niveau", nullable = false, length = 30)
    private String niveau;
    @Basic
    @Column(name = "etablisement", nullable = false, length = 30)
    private String etablisement;
    @OneToOne(mappedBy = "etudientByFkEtudient")
    private Candidat candidatsById;
    @OneToMany(mappedBy = "etudientByFkEtudient")
    private Collection<ElectionEtudient> electionEtudientsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIne() {
        return ine;
    }

    public void setIne(int ine) {
        this.ine = ine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInscription() {
        return inscription;
    }

    public void setInscription(String inscription) {
        this.inscription = inscription;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getEtablisement() {
        return etablisement;
    }

    public void setEtablisement(String etablisement) {
        this.etablisement = etablisement;
    }

    public Candidat getCandidatsById() {
        return candidatsById;
    }

    public void setCandidatsById(Candidat candidatsById) {
        this.candidatsById = candidatsById;
    }

    public Collection<ElectionEtudient> getElectionEtudientsById() {
        return electionEtudientsById;
    }

    public void setElectionEtudientsById(Collection<ElectionEtudient> electionEtudientsById) {
        this.electionEtudientsById = electionEtudientsById;
    }
}
