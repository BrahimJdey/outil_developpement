package com.iscae.Election.Repository;

import com.iscae.Election.Model.Syndicat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyndicatRepo extends JpaRepository<Syndicat, Integer> {
}
