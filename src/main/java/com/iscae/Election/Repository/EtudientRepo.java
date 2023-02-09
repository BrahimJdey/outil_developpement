package com.iscae.Election.Repository;

import com.iscae.Election.Model.Etudient;
import com.iscae.Election.crud.dtos.EtudientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EtudientRepo extends JpaRepository<Etudient, Integer> {


//    @Query("select new com.iscae.Election.crud.dtos.EtudientDto(" +
//            "e.id, e.ine, e.nom, e.prenom, " +
//            "e.date, " +
//            "e.email," +
//            "e.password," +
//            "e.inscription," +
//            "e.niveau," +
//            "e.etablisement) " +
//            "from Etudient e ")
//    List<EtudientDto> findAll();

}
