package com.peliculas.model;

import com.peliculas.utils.StringCompare;

/**
 * Pelicula
 */
public class Pelicula {

	private Integer id;
	private String nombre;
	private Integer minutos;
	private Genero genero;
	private String director;

	public Pelicula(String nombre, Integer minutos, Genero genero, String director) {
		this(null, nombre, minutos, genero, director);
	}

	public Pelicula(Integer id, String nombre, Integer minutos, Genero genero, String director) {
		this.id = id;
		this.nombre = nombre;
		this.minutos = minutos;
		this.genero = genero;
		this.director = director;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the minutos
	 */
	public Integer getMinutos() {
		return minutos;
	}

	/**
	 * @return the genero
	 */
	public Genero getGenero() {
		return genero;
	}

	public String getDirector() {
		return director;
	}


	public boolean matchPlantilla(Pelicula plantilla) {
		if (plantilla.director != null && !StringCompare.contieneIngoreCase(plantilla.director, director)) {
			return false;
		}
		if (plantilla.nombre != null && !StringCompare.contieneIngoreCase(plantilla.nombre, nombre)) {
			return false;
		}
		if (plantilla.minutos != null && plantilla.minutos < minutos) {
			return false;
		}
		if (plantilla.genero != null && !plantilla.genero.equals(genero)) {
			return false;
		}
			
		return true;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((director == null) ? 0 : director.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((minutos == null) ? 0 : minutos.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        if (director == null) {
            if (other.director != null)
                return false;
        } else if (!director.equals(other.director))
            return false;
        if (genero != other.genero)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (minutos == null) {
            if (other.minutos != null)
                return false;
        } else if (!minutos.equals(other.minutos))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", nombre=" + nombre + ", minutos=" + minutos + ", genero=" + genero
                + ", director=" + director + "]";
    }

}
