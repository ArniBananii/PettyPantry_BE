package de.pettypantry;

import de.pettypantry.web.IngredientController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {


   @Autowired
    private IngredientController testIngredientController;


    @Test
    void smokeTest() {
        assert (testIngredientController != null);
    }





}
