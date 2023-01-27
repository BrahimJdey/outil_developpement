package com.iscae.Election.Repository;

import com.iscae.Election.Model.ElectionSyndicat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Election_SyndicatRepo extends JpaRepository<ElectionSyndicat, Integer> {
        }
