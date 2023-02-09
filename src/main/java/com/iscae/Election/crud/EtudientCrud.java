package com.iscae.Election.crud;

import com.iscae.Election.Repository.EtudientRepo;
import com.iscae.Election.Model.Etudient;
import com.iscae.Election.crud.dtos.EtudientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Etudiant")
public class EtudientCrud {

    private final EtudientRepo etudientRepo;

    @Autowired
    public EtudientCrud(EtudientRepo etudientRepo) {
        this.etudientRepo = etudientRepo;
    }

    @GetMapping
    public List<EtudientDto> getAll() {
        List<EtudientDto> etudientDtos = etudientRepo
                .findAll()
                .stream()
                .map(p -> {
                    EtudientDto etudientDto = new EtudientDto();
                    etudientDto.setId(p.getId());
                    etudientDto.setNom(p.getNom());
                    etudientDto.setPrenom(p.getPrenom());
                    etudientDto.setDate(p.getDate());
                    etudientDto.setEmail(p.getEmail());
                    etudientDto.setPassword(p.getPassword());
                    etudientDto.setInscription(p.getInscription());
                    etudientDto.setNiveau(p.getNiveau());
                    etudientDto.setEtablisement(p.getEtablisement());

                    return etudientDto;
                }).collect(Collectors.toList());
        return etudientDtos;
    }

    @GetMapping("/{id}")
    public EtudientDto byId(@PathVariable("id") Integer id) {
        try {
            Etudient etudient = etudientRepo.findById(id).orElseThrow();
            EtudientDto etudientDto = new EtudientDto();
            etudientDto.setId(etudient.getId());
            etudientDto.setNom(etudient.getNom());
            etudientDto.setPrenom(etudient.getPrenom());
            etudientDto.setDate(etudient.getDate());
            etudientDto.setEmail(etudient.getEmail());
            etudientDto.setPassword(etudient.getPassword());
            etudientDto.setInscription(etudient.getInscription());
            etudientDto.setNiveau(etudient.getNiveau());
            etudientDto.setEtablisement(etudient.getEtablisement());

            return etudientDto;
        } catch (NoSuchElementException e) {
            System.out.println("L'élement n'existe pas ======================= ");
            return null;
        }
    }


    @PostMapping
    public void add(@RequestBody EtudientDto etudientDto) {
        Etudient etudient = new Etudient();
        etudient.setIne(etudientDto.getIne());
        etudient.setNom(etudientDto.getNom());
        etudient.setPrenom(etudientDto.getPrenom());
        etudient.setDate(etudientDto.getDate());
        etudient.setEmail(etudientDto.getEmail());
        etudient.setPassword(etudientDto.getPassword());
        etudient.setInscription(etudientDto.getInscription());
        etudient.setNiveau(etudientDto.getNiveau());
        etudient.setEtablisement(etudientDto.getEtablisement());


        etudientRepo.save(etudient);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EtudientDto etudientDto, @PathVariable("id") Integer id) {
        Etudient etudient = etudientRepo.findById(id).orElseThrow();
        etudient.setIne(etudientDto.getIne());
        etudient.setNom(etudientDto.getNom());
        etudient.setPrenom(etudientDto.getPrenom());
        etudient.setDate(etudientDto.getDate());
        etudient.setEmail(etudientDto.getEmail());
        etudient.setPassword(etudientDto.getPassword());
        etudient.setInscription(etudientDto.getInscription());
        etudient.setNiveau(etudientDto.getNiveau());
        etudient.setEtablisement(etudientDto.getEtablisement());


        etudientRepo.save(etudient);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        etudientRepo.deleteById(id);
    }


}
