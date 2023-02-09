package com.iscae.Election.crud;

import com.iscae.Election.Model.Election;
import com.iscae.Election.Repository.ElectionRepository;
import com.iscae.Election.crud.dtos.Election_Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Election")
public class ElectionCrud {

    private final ElectionRepository electionRepo;

    @Autowired
    public ElectionCrud(ElectionRepository electionRepo) {
        this.electionRepo = electionRepo;
    }

    @GetMapping
    public List<Election_Dto> getAll() {
        List<Election_Dto> election_Dtos = electionRepo
                .findAll()
                .stream()
                .map(p -> {
                    Election_Dto election_dto = new Election_Dto();
                    election_dto.setId(p.getId());
                    election_dto.setDate_Debit(p.getDateDebit());
                    election_dto.setDate_Fin(p.getDateFin());
                    election_dto.setSujet(p.getSujet());

                    return election_dto;
                }).collect(Collectors.toList());
        return election_Dtos;
    }

    @GetMapping("/{id}")
    public Election_Dto byId(@PathVariable("id") Integer id) {
        try {
            Election candidat = electionRepo.findById(id).orElseThrow();
            Election_Dto election_dto = new Election_Dto();
            election_dto.setId(candidat.getId());
            election_dto.setDate_Debit(candidat.getDateDebit());
            election_dto.setDate_Fin(candidat.getDateFin());
            election_dto.setSujet(candidat.getSujet());

            return election_dto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping
    public void add(@RequestBody Election_Dto election_dto) {
        Election election = new Election();
        election.setDateDebit(election_dto.getDate_Debit());
        election.setDateFin(election_dto.getDate_Fin());
        election.setSujet(election_dto.getSujet());

        electionRepo.save(election);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Election_Dto election_dto, @PathVariable("id") Integer id) {
        Election election = electionRepo.findById(id).orElseThrow();
        election.setDateDebit(election_dto.getDate_Debit());
        election.setDateFin(election_dto.getDate_Fin());
        election.setSujet(election_dto.getSujet());

        electionRepo.save(election);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        electionRepo.deleteById(id);
    }


}
