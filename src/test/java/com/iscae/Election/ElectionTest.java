package com.iscae.Election;

import com.iscae.Election.Model.Election;
import com.iscae.Election.Repository.ElectionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.UnexpectedRollbackException;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ElectionTest {
    @Autowired private ElectionRepository Erep;

    @Test
    public void testAddNew(){
        Election e = new Election();
        e.setSujet("Election 2");
        e.setDateDebit("22/12/2022");
        e.setDateFin("23/12/2022");
       Election election = Erep.save(e);
        Assertions.assertThat(election).isNotNull();
        Assertions.assertThat(election.getId()).isGreaterThan(0);
    }
    @Test
    public  void testListAll(){
        Iterable<Election> elections =Erep.findAll();
        Assertions.assertThat(elections).hasSizeGreaterThan(0);
        for (Election election : elections) {
            System.out.print(election);

        }
    }

    @Test
    public void update(){
        Integer electionId =2;
       Optional<Election> optionElection = Erep.findById((electionId));
       Election election= optionElection.get();
       election.setSujet("test2");
       Erep.save(election);

       Election updateElection = Erep.findById(electionId).get();
       Assertions.assertThat(updateElection.getSujet()).isEqualTo("test");
    }
    @Test
    public void testGet(){
        Integer electionId =1;
        Optional<Election> optionElection = Erep.findById((electionId));
        Assertions.assertThat(optionElection).isPresent();
        System.out.println(optionElection.get());

    }
    @Test
    public void testDelete() {
        try {
            Integer   electionId =1;
            Erep.deleteById(electionId);

            Optional<Election> optionElection = Erep.findById((electionId));
            Assertions.assertThat(optionElection).isNotPresent();
        }catch(EmptyResultDataAccessException e){
            System.out.println("inexiste");
        }


    }
}


