package com.peliculas.service;

import com.peliculas.data.PeliculaRepository;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * PeliculaServiceTest
 */
public class PeliculaServiceTest {

    private PeliculaService peliculaService;

    @Before
    public void setup() {
        PeliculaRepository peliculaRepository = mock(PeliculaRepository.class);
        when(peliculaRepository.findAll()).thenReturn(Arrays.asList(
            new Pelicula(1, "Dark Knight", 152, Genero.ACCION),
            new Pelicula(2, "Memento", 113, Genero.DRAMA),
            new Pelicula(3, "There's Something About Mary", 119, Genero.COMEDIA),
            new Pelicula(4, "Super 8", 112, Genero.DRAMA),
            new Pelicula(5, "Scream", 111, Genero.TERROR),
            new Pelicula(6, "Home Alone", 103, Genero.COMEDIA),
            new Pelicula(7, "Matrix", 136, Genero.ACCION)
        ));
        peliculaService = new PeliculaService(peliculaRepository);
    }

    @Test
    public void deberia_retornar_peliculas_por_genero() {
        Collection<Pelicula> peliculas = peliculaService.findByGenero(Genero.COMEDIA);
        assertThat(getPeliculasIds(peliculas), is(Arrays.asList(3, 6)));
    }

    @Test
    public void deberia_retornar_peliculas_por_duracion() {
        Collection<Pelicula> peliculas = peliculaService.findByDuracionHasta(112);
        assertThat(getPeliculasIds(peliculas), is(Arrays.asList(4, 5, 6)));
    }

    private List<Integer> getPeliculasIds(Collection<Pelicula> peliculas) {
        return peliculas.stream().map(Pelicula::getId).collect(Collectors.toList());
    }

}
