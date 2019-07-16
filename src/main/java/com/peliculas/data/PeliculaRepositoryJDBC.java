package com.peliculas.data;

import java.sql.ResultSet;
import java.util.Collection;

import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * PeliculaRepositoryJDBC
 */
public class PeliculaRepositoryJDBC implements PeliculaRepository {

    private JdbcTemplate jdbcTemplate;

    public PeliculaRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Pelicula findById(long id) {
        return null;
    }

    @Override
    public Collection<Pelicula> findAll() {
        return jdbcTemplate.query("select * from pelicula", peliculaMapper);
    }

    @Override
    public void saveOrUpdate(Pelicula pelicula) {

    }

    private static RowMapper<Pelicula> peliculaMapper = (ResultSet rs, int rowNum) ->
             new Pelicula(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getInt("minutos"),
                Genero.valueOf(rs.getString("genero")));


}
