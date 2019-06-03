package com.ostanin.docker.dockerspringboot.Controller;


import com.ostanin.docker.dockerspringboot.service.FilmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    FilmService filmService;

    @GetMapping("/home")
    public String home(Model model) {
        logger.info("Вызов контроллера " + getClass().getName());
        filmService.countAddOne();
        model.addAttribute("ALL_FILMS", filmService.findAll());
        return "home";
    }
}
