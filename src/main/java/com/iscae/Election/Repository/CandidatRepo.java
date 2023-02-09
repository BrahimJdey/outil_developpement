package com.iscae.Election.Repository;

import com.iscae.Election.Model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatRepo extends JpaRepository<Candidat, Integer> {
}
