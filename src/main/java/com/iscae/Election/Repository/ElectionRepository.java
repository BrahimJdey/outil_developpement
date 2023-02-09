package com.iscae.Election.Repository;

import com.iscae.Election.Model.Candidat;
import com.iscae.Election.Model.Election;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ElectionRepository extends JpaRepository<Election, Integer> {
}
