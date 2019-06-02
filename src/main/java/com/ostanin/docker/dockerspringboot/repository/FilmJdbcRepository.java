package com.ostanin.docker.dockerspringboot.repository;

import com.ostanin.docker.dockerspringboot.dto.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FilmJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private class FilmRowMapper implements RowMapper<Film> {
        @Override
        public Film mapRow(ResultSet resultSet, int i) throws SQLException {
            Film film = new Film();
            film.setId(resultSet.getLong("id"));
            film.setTitle(resultSet.getString("title"));
            film.setProducer(resultSet.getString("producer"));
            film.setPoints(resultSet.getDouble("points"));
            return film;
        }
    }

    public List<Film> findAll() {
        String sql = "select * from film";
        return jdbcTemplate.query(sql, new FilmRowMapper());
    }
}
