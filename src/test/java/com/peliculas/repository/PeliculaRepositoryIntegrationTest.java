package com.peliculas.repository;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import com.peliculas.data.PeliculaRepositoryJDBC;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.jdbc.datasource.init.ScriptUtils;

/**
 * PeliculaRepositoryIntegrationTest
 */
public class PeliculaRepositoryIntegrationTest {

    private static DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");
    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    private static PeliculaRepositoryJDBC peliculaRepository;

    @BeforeAll
    static void setup() throws ScriptException, SQLException {
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql\\test-data.sql"));
        peliculaRepository = new PeliculaRepositoryJDBC(jdbcTemplate);
    }
    
    @Test
    void deberia_insertar_una_pelicula() {
    	peliculaRepository.saveOrUpdate(new Pelicula("Super 8", 112, Genero.DRAMA, "J. J. Abrams"));
    	Pelicula nuevaPelicula = peliculaRepository.findById(4);
    	assertThat(nuevaPelicula, is(new Pelicula(4, "Super 8", 112, Genero.DRAMA, "J. J. Abrams")));
    }

    
    @Test
    void deberia_retornar_una_pelicula_por_id() {
		Pelicula pelicula = peliculaRepository.findById(2);
		assertThat(pelicula, is(new Pelicula(2, "Memento", 113, Genero.DRAMA, "Christopher Nolan")));
	}
    
    @Test
    void deberia_retornar_todas_las_peliculas()  {
        Collection<Pelicula> pelis =  peliculaRepository.findAll();
        assertThat(pelis, is(Arrays.asList(
            new Pelicula(1, "Dark Knight", 152, Genero.ACCION, "Christopher Nolan") ,
            new Pelicula(2, "Memento", 113, Genero.DRAMA, "Christopher Nolan") ,
            new Pelicula(3, "Matrix", 136, Genero.ACCION, "Wachowski brothers")
        )));
    }
    
}
