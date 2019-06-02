package com.ostanin.docker.dockerspringboot.Controller;


import com.ostanin.docker.dockerspringboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    FilmService filmService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("ALL_FILMS", filmService.findAll());
        return "/home";
    }
}
