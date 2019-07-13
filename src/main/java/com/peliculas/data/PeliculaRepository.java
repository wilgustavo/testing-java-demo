package com.peliculas.data;

import java.util.Collection;

import com.peliculas.model.Pelicula;

/**
 * PeliculaService
 */
public interface PeliculaRepository {

    Pelicula findById(long id);
    Collection<Pelicula> findAll();
    void saveOrUpdate(Pelicula pelicula);

}
