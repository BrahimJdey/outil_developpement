package com.iscae.Election.Repository;

import com.iscae.Election.Model.ElectionEtudient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Election_EtudiantRepo extends JpaRepository<ElectionEtudient, Integer> {
}
