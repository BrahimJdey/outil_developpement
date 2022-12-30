package com.iscae.Election.Repository;

import com.iscae.Election.Model.Election;
import org.springframework.data.repository.CrudRepository;


public interface ElectionRepository extends CrudRepository<Election, Integer> {

}
