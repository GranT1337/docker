package com.ostanin.docker.dockerspringboot.service;

import com.ostanin.docker.dockerspringboot.dto.Film;
import com.ostanin.docker.dockerspringboot.repository.FilmJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    FilmJdbcRepository repository;

    public List<Film> findAll() {
        return repository.findAll();
    }
}
