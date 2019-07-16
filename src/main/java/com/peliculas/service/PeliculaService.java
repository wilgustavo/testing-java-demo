package com.peliculas.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.peliculas.data.PeliculaRepository;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;

/**
 * PeliculaService.
 */
public class PeliculaService {

	/** The pelicula repository. */
	private PeliculaRepository peliculaRepository;

	/**
	 * Instantiates a new pelicula service.
	 *
	 * @param peliculaRepository the pelicula repository
	 */
	public PeliculaService(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	/**
	 * Find by genero.
	 *
	 * @param genero the genero
	 * @return the collection
	 */
	public Collection<Pelicula> findByGenero(Genero genero) {
		return peliculaRepository.findAll().stream().filter(peli -> peli.getGenero() == genero)
				.collect(Collectors.toList());
	}

	/**
	 * Find by duracion hasta.
	 *
	 * @param minutos the minutos
	 * @return the collection
	 */
	public Collection<Pelicula> findByDuracionHasta(int minutos) {
		return peliculaRepository.findAll().stream().filter(peli -> peli.getMinutos() <= minutos)
				.collect(Collectors.toList());
	}

	/**
	 * Find by nombre.
	 *
	 * @param busqueda the busqueda
	 * @return the collection
	 */
	public Collection<Pelicula> findByNombre(String busqueda) {
		return peliculaRepository.findAll().stream()
				.filter(peli -> contieneNombre(busqueda, peli))
				.collect(Collectors.toList());
	}

	private boolean contieneNombre(String busqueda, Pelicula peli) {
		return peli.getNombre().toUpperCase().contains(busqueda.toUpperCase());
	}

}
