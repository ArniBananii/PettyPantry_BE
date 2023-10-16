package de.pettypantry.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public ModelAndView helloWorld() {
        return new ModelAndView("helloWorld");
    }
}
