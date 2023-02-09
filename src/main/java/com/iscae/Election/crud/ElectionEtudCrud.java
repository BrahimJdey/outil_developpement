package com.iscae.Election.crud;

import com.iscae.Election.Model.ElectionEtudient;
import com.iscae.Election.Repository.Election_EtudiantRepo;
import com.iscae.Election.crud.dtos.ElectionEtudient_Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ElectionEtudiant")
public class ElectionEtudCrud {

    private final Election_EtudiantRepo electionRepo;

    @Autowired
    public ElectionEtudCrud(Election_EtudiantRepo electionRepo) {
        this.electionRepo = electionRepo;
    }

    @GetMapping
    public List<ElectionEtudient_Dto> getAll() {
        List<ElectionEtudient_Dto> election_Dtos = electionRepo
                .findAll()
                .stream()
                .map(p -> {
                    ElectionEtudient_Dto election_dto = new ElectionEtudient_Dto();
                    election_dto.setId(p.getId());
                    election_dto.setStatus(p.getStatus());
                    election_dto.setFK_Etudient(p.getFkEtudient());
                    election_dto.setFK_Election(p.getFkElection());

                    return election_dto;
                }).collect(Collectors.toList());
        return election_Dtos;
    }

    @GetMapping("/{id}")
    public ElectionEtudient_Dto byId(@PathVariable("id") Integer id) {
        try {
            ElectionEtudient electionEtudient = electionRepo.findById(id).orElseThrow();
            ElectionEtudient_Dto election_dto = new ElectionEtudient_Dto();
            election_dto.setId(electionEtudient.getId());
            election_dto.setStatus(electionEtudient.getStatus());
            election_dto.setFK_Etudient(electionEtudient.getFkEtudient());
            election_dto.setFK_Election(electionEtudient.getFkElection());

            return election_dto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping("/add")
    public void add(@RequestBody ElectionEtudient_Dto election_dto) {
        ElectionEtudient election = new ElectionEtudient();
        election.setStatus(election_dto.getStatus());
        election.setFkEtudient(election_dto.getFK_Etudient());
        election.setFkElection(election_dto.getFK_Election());

        electionRepo.save(election);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody ElectionEtudient_Dto election_dto, @PathVariable("id") Integer id) {
        ElectionEtudient election = electionRepo.findById(id).orElseThrow();
        election.setStatus(election_dto.getStatus());
        election.setFkEtudient(election_dto.getFK_Etudient());
        election.setFkElection(election_dto.getFK_Etudient());

        electionRepo.save(election);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        electionRepo.deleteById(id);
    }


}
