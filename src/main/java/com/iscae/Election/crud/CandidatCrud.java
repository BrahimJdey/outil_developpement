package com.iscae.Election.crud;

import com.iscae.Election.Model.Candidat;
import com.iscae.Election.Repository.CandidatRepo;
import com.iscae.Election.crud.dtos.Candidat_Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Candidat")
public class CandidatCrud {

    private final  CandidatRepo candidatRepo;

    @Autowired
    public CandidatCrud(CandidatRepo candidatRepo) {
        this.candidatRepo = candidatRepo;
    }

    @GetMapping
    public List<Candidat_Dto> getAll() {
        List<Candidat_Dto> candidat_Dtos = candidatRepo
                .findAll()
                .stream()
                .map(p -> {
                    Candidat_Dto candidat_Dto = new Candidat_Dto();
                    candidat_Dto.setId(p.getId());
                    candidat_Dto.setFK_Etudient(p.getFkEtudient());
                    candidat_Dto.setFK_Syndicat(p.getFkSyndicat());

                    return candidat_Dto;
                }).collect(Collectors.toList());
        return candidat_Dtos;
    }

    @GetMapping("/{id}")
    public Candidat_Dto byId(@PathVariable("id") Integer id) {
        try {
            Candidat candidat = candidatRepo.findById(id).orElseThrow();
            Candidat_Dto candidat_Dto = new Candidat_Dto();
            candidat_Dto.setId(candidat.getId());
            candidat_Dto.setFK_Etudient(candidat.getFkEtudient());
            candidat_Dto.setFK_Syndicat(candidat.getFkSyndicat());

            return candidat_Dto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping
    public void add(@RequestBody Candidat_Dto candidat_Dto) {
        Candidat candidat = new Candidat();
        candidat.setFkEtudient(candidat_Dto.getFK_Etudient());
        candidat.setFkSyndicat(candidat_Dto.getFK_Syndicat());

        candidatRepo.save(candidat);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Candidat_Dto candidat_Dto, @PathVariable("id") Integer id) {
        Candidat candidat = candidatRepo.findById(id).orElseThrow();
        candidat.setFkEtudient(candidat_Dto.getFK_Etudient());
        candidat.setFkSyndicat(candidat_Dto.getFK_Syndicat());

        candidatRepo.save(candidat);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        candidatRepo.deleteById(id);
    }


}
