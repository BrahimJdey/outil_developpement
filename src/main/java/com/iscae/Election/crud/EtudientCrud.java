package com.iscae.Election.crud;
import com.iscae.Election.Model.Etudient;

import com.iscae.Election.Repository.EtudientRepo;
import com.iscae.Election.crud.dtos.EtudientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Etudiant")
public class EtudientCrud {

    private final EtudientRepo etudientRepo;

    @Autowired
    public Etudient(EtudientRepo etudientRepo) {
        this.etudientRepo = etudientRepo;
    }

    @GetMapping
    public List<EtudientDto> getAll() {
        List<EtudientDto> etudientDtos = EtudientRepo
                .findAll()
                .stream()
                .map(p -> {
                    EtudientDto etudientDto = new EtudientDto();
                    etudientDto.setId(p.getId());
                    etudientDto.setNom(p.getNom());
                    etudientDto.setPrenom(p.getPrenom());
                    etudientDto.setTel(p.getTel());
                    etudientDto.setIdGenre(p.getIdGenre());
                    etudientDto.setIdGenre(p.getIdGenre());
                    etudientDto.setIdGenre(p.getIdGenre());
                    etudientDto.setIdGenre(p.getIdGenre());
                    etudientDto.setIdGenre(p.getIdGenre());

                    return etudientDto;
                }).collect(Collectors.toList());
        return etudientDtos;
    }

}
