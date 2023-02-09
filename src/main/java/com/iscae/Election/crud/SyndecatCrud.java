package com.iscae.Election.crud;

import com.iscae.Election.Model.Syndicat;
import com.iscae.Election.Repository.SyndicatRepo;
import com.iscae.Election.crud.dtos.SyndicatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Syndecat")
public class SyndecatCrud {

    private final SyndicatRepo syndicatRepo;

    @Autowired
    public SyndecatCrud(SyndicatRepo syndicatRepo) {
        this.syndicatRepo = syndicatRepo;
    }

    @GetMapping
    public List<SyndicatDto> getAll() {
        List<SyndicatDto> syndicatDtos = syndicatRepo
                .findAll()
                .stream()
                .map(p -> {
                    SyndicatDto syndicatDto = new SyndicatDto();
                    syndicatDto.setId(p.getId());
                    syndicatDto.setSyndicat_type(p.getSyndicatType());
                    syndicatDto.setSyndicat_nom(p.getSyndicatNom());
                    syndicatDto.setLogo(p.getLogo());

                    return syndicatDto;
                }).collect(Collectors.toList());
        return syndicatDtos;
    }

    @GetMapping("/{id}")
    public SyndicatDto byId(@PathVariable("id") Integer id) {
        try {
            Syndicat syndicat = syndicatRepo.findById(id).orElseThrow();
            SyndicatDto syndicatDto = new SyndicatDto();
            syndicatDto.setId(syndicat.getId());
            syndicatDto.setSyndicat_type(syndicat.getSyndicatType());
            syndicatDto.setSyndicat_nom(syndicat.getSyndicatNom());
            syndicatDto.setLogo(syndicat.getLogo());

            return syndicatDto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping
    public void add(@RequestBody SyndicatDto syndicatDto) {
        Syndicat syndicat = new Syndicat();
        syndicat.setSyndicatType(syndicatDto.getSyndicat_type());
        syndicat.setSyndicatNom(syndicatDto.getSyndicat_nom());
        syndicat.setLogo(syndicatDto.getLogo());

        syndicatRepo.save(syndicat);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody SyndicatDto syndicatDto, @PathVariable("id") Integer id) {
        Syndicat syndicat = syndicatRepo.findById(id).orElseThrow();
        syndicat.setSyndicatType(syndicatDto.getSyndicat_type());
        syndicat.setSyndicatNom(syndicatDto.getSyndicat_nom());
        syndicat.setLogo(syndicatDto.getLogo());

        syndicatRepo.save(syndicat);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        syndicatRepo.deleteById(id);
    }


}
