package de.pettypantry.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepo gives us all the CRUD methods for sql @runtime !
@Repository
public interface PersonsReposetory extends JpaRepository<PersonsEntity, Integer> {

    // Needs to be specific naming! method name is the query !
    List<PersonsEntity> findAllByFirstName(String firstName);

}
