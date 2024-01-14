package de.pettypantry;

import de.pettypantry.service.IngredientService;
import de.pettypantry.web.IngredientController;
import de.pettypantry.web.api.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IngredientController.class)
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientService testIngredientService;


    @Test
    void testIngredientController() throws Exception {
        Ingredient testIngredient = mock(Ingredient.class);
        when(testIngredient.getIngredientID()).thenReturn(-1);
        when(testIngredient.getIngredientName()).thenReturn("TestIngredient");
        when(testIngredient.getValidNoOfDays()).thenReturn(1);
        when(testIngredient.getImageURL()).thenReturn("TestURL");

        when(testIngredientService.findAll()).thenReturn(List.of(testIngredient));


        mockMvc.perform(get("/api/v1/ingredients")).andExpectAll(
                status().is(201),
                content().string(containsString("TestIngredient"))
        );

    }
}
