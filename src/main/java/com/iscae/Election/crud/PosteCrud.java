package com.iscae.Election.crud;

import com.iscae.Election.Model.Poste;
import com.iscae.Election.Repository.PosteRepo;
import com.iscae.Election.crud.dtos.Election_Dto;
import com.iscae.Election.crud.dtos.PosteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Poste")
public class PosteCrud {

    private final PosteRepo posteRepo;

    @Autowired
    public PosteCrud(PosteRepo posteRepo) {
        this.posteRepo = posteRepo;
    }

    @GetMapping
    public List<PosteDto> getAll() {
        List<PosteDto> posteDtos = posteRepo
                .findAll()
                .stream()
                .map(p -> {
                    PosteDto posteDto = new PosteDto();
                    posteDto.setId(p.getId());
                    posteDto.setLibelle(p.getLibelle());
                    posteDto.setFK_Syndicat(p.getFkSyndicat());
                    posteDto.setDescription(p.getDescription());

                    return posteDto;
                }).collect(Collectors.toList());
        return posteDtos;
    }

    @GetMapping("/{id}")
    public PosteDto byId(@PathVariable("id") Integer id) {
        try {
            Poste poste = posteRepo.findById(id).orElseThrow();
            PosteDto posteDto = new PosteDto();
            posteDto.setId(poste.getId());
            posteDto.setLibelle(poste.getLibelle());
            posteDto.setFK_Syndicat(poste.getFkSyndicat());
            posteDto.setDescription(poste.getDescription());

            return posteDto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping("/add")
    public void add(@RequestBody PosteDto posteDto) {
        Poste poste = new Poste();
        poste.setLibelle(posteDto.getLibelle());
        poste.setFkSyndicat(posteDto.getFK_Syndicat());
        poste.setDescription(posteDto.getDescription());

        posteRepo.save(poste);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody PosteDto posteDto, @PathVariable("id") Integer id) {
        Poste poste = posteRepo.findById(id).orElseThrow();
        poste.setLibelle(posteDto.getLibelle());
        poste.setFkSyndicat(posteDto.getFK_Syndicat());
        poste.setDescription(posteDto.getDescription());

        posteRepo.save(poste);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        posteRepo.deleteById(id);
    }


}
