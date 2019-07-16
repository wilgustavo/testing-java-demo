package com.peliculas.model;

/**
 * Pelicula
 */
public class Pelicula {

    private Integer id;
    private String nombre;
    private int minutos;
    private Genero genero;
    private String director;

    public Pelicula(String nombre, int minutos, Genero genero, String director) {
        this(null, nombre, minutos, genero, director);
    }

    public Pelicula(Integer id, String nombre, int minutos, Genero genero, String director) {
        this.id = id;
        this.nombre = nombre;
        this.minutos = minutos;
        this.genero = genero;
        this.setDirector(director);
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
    public int getMinutos() {
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

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + minutos;
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
		if (minutos != other.minutos)
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
