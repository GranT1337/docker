package com.ostanin.docker.dockerspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor


public class Film {
    private long id;
    //@NotEmpty(message="Название фильма должно быть задано")
    private String title;
    //@NotEmpty(message="Режиссёр должен быть указан")
    private String producer;
    //@Pattern(regexp = "(\\d+.?,?\\d+)", message = "Неправильно указан балл")
    //@NotNull(message = "Please enter points")
    private double points;
}
