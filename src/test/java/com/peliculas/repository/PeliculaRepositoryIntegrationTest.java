package com.peliculas.repository;

import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import javax.sql.DataSource;

import com.peliculas.data.PeliculaRepositoryJDBC;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
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
    private PeliculaRepositoryJDBC peliculaRepository;

    @Before
    public void setup() throws ScriptException, SQLException {
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql\\test-data.sql"));
        peliculaRepository = new PeliculaRepositoryJDBC(jdbcTemplate);
    }
    
    @Test
    public void deberia_insertar_una_pelicula() {
    	peliculaRepository.saveOrUpdate(new Pelicula("Super 8", 112, Genero.DRAMA, "J. J. Abrams"));
    	Pelicula nuevaPelicula = peliculaRepository.findById(4);
    	assertThat(nuevaPelicula, is(new Pelicula(4, "Super 8", 112, Genero.DRAMA, "J. J. Abrams")));
    }

    
    @Test
    public void deberia_retornar_una_pelicula_por_id() {
		Pelicula pelicula = peliculaRepository.findById(2);
		assertThat(pelicula, is(new Pelicula(2, "Memento", 113, Genero.DRAMA, "Christopher Nolan")));
	}
    
    @Test
    public void deberia_retornar_todas_las_peliculas()  {
        Collection<Pelicula> pelis =  peliculaRepository.findAll();
        assertThat(pelis, is(Arrays.asList(
            new Pelicula(1, "Dark Knight", 152, Genero.ACCION, "Christopher Nolan") ,
            new Pelicula(2, "Memento", 113, Genero.DRAMA, "Christopher Nolan") ,
            new Pelicula(3, "Matrix", 136, Genero.ACCION, "Wachowski brothers")
        )));
    }
    
}
