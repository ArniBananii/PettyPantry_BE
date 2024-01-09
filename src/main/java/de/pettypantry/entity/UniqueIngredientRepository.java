package de.pettypantry.entity;

import de.pettypantry.web.api.UniqueIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniqueIngredientRepository extends JpaRepository<UniqueIngredientEntity, Integer> {
}
