package com.peliculas.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.peliculas.data.PeliculaRepository;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;

/**
 * PeliculaService
 */
public class PeliculaService {

    private PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

	public Collection<Pelicula> findByGenero(Genero genero) {
        return peliculaRepository.findAll().stream()
            .filter(peli -> peli.getGenero() == genero).collect(Collectors.toList());
	}



}
