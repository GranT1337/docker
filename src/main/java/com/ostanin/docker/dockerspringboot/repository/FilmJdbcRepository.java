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
            film.setCount(resultSet.getInt("count"));
            return film;
        }
    }

    public List<Film> findAll() {
        String sql = "select * from film";
        return jdbcTemplate.query(sql, new FilmRowMapper());
    }

    public int addOneDigit() {
        String sql = "UPDATE film\n" +
                "SET count = count + 1";
        return jdbcTemplate.update(sql);
    }

    public void createTable() {
        String sqlDrop="DROP TABLE IF EXISTS film;";
        jdbcTemplate.execute(sqlDrop);
        String sql = "create table film\n" +
                "(\n" +
                "   id serial PRIMARY KEY,\n" +
                "   title varchar(255),\n" +
                "   producer varchar(255),\n" +
                "   points double precision,\n" +
                "   count integer\n" +
                ");";
        jdbcTemplate.execute(sql);
        jdbcTemplate.execute("insert into film(title, producer, points,count)\n" +
                "values('Малхолланд Драйв', 'Дэвид Линч', 7.65, 1);");

    }
}
