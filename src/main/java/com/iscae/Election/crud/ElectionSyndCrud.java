package com.iscae.Election.crud;

import com.iscae.Election.Model.ElectionSyndicat;
import com.iscae.Election.Repository.Election_SyndicatRepo;
import com.iscae.Election.crud.dtos.Election_SyndecatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("ElectionSyndicat")
public class ElectionSyndCrud {

    private final Election_SyndicatRepo electionRepo;

    @Autowired
    public ElectionSyndCrud(Election_SyndicatRepo electionRepo) {
        this.electionRepo = electionRepo;
    }

    @GetMapping
    public List<Election_SyndecatDto> getAll() {
        List<Election_SyndecatDto> election_Dtos = electionRepo
                .findAll()
                .stream()
                .map(p -> {
                    Election_SyndecatDto election_dto = new Election_SyndecatDto();
                    election_dto.setId(p.getId());
                    election_dto.setFK_Election(p.getFkElection());
                    election_dto.setFK_Syndicat(p.getFkSyndicat());
                    election_dto.setNombreElecteurs(p.getNombreElecteurs());

                    return election_dto;
                }).collect(Collectors.toList());
        return election_Dtos;
    }

    @GetMapping("/{id}")
    public Election_SyndecatDto byId(@PathVariable("id") Integer id) {
        try {
            ElectionSyndicat syndicat = electionRepo.findById(id).orElseThrow();
            Election_SyndecatDto election_dto = new Election_SyndecatDto();
            election_dto.setId(syndicat.getId());
            election_dto.setFK_Election(syndicat.getFkElection());
            election_dto.setFK_Syndicat(syndicat.getFkSyndicat());
            election_dto.setNombreElecteurs(syndicat.getNombreElecteurs());

            return election_dto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping("/add")
    public void add(@RequestBody Election_SyndecatDto election_dto) {
        ElectionSyndicat election = new ElectionSyndicat();
        election.setFkElection(election_dto.getFK_Election());
        election.setFkSyndicat(election_dto.getFK_Syndicat());
        election.setNombreElecteurs(election_dto.getNombreElecteurs());

        electionRepo.save(election);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Election_SyndecatDto election_dto, @PathVariable("id") Integer id) {
        ElectionSyndicat election = electionRepo.findById(id).orElseThrow();
        election.setFkElection(election_dto.getFK_Election());
        election.setFkSyndicat(election_dto.getFK_Syndicat());
        election.setNombreElecteurs(election_dto.getNombreElecteurs());

        electionRepo.save(election);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        electionRepo.deleteById(id);
    }


}
