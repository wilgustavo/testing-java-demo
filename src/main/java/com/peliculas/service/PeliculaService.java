package com.peliculas.service;

import java.util.Collection;
import java.util.stream.Collectors;

import com.peliculas.data.PeliculaRepository;
import com.peliculas.model.Genero;
import com.peliculas.model.Pelicula;
import com.peliculas.utils.StringCompare;

// TODO: Auto-generated Javadoc
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
		return peliculaRepository.findAll().stream().filter(peli -> StringCompare.contieneIngoreCase(busqueda, peli.getNombre()))
				.collect(Collectors.toList());
	}

	/**
	 * Find by director.
	 *
	 * @param string the string
	 * @return the collection
	 */
	public Collection<Pelicula> findByDirector(String busqueda) {
		return peliculaRepository.findAll().stream().filter(peli -> StringCompare.contieneIngoreCase(busqueda, peli.getDirector()))
				.collect(Collectors.toList());
	}

	public Collection<Pelicula> findByPlantilla(Pelicula plantilla) {
		return peliculaRepository.findAll().stream().filter(peli -> peli.matchPlantilla(plantilla))
				.collect(Collectors.toList());
	}

}
