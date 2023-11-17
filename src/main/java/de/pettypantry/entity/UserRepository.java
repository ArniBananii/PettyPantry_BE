package de.pettypantry.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//JpaRepo gives us all the CRUD methods for sql @runtime !
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    // Needs to be specific naming! method name is the query !
    List<UserEntity> findAllByFirstName(String firstName);

}
