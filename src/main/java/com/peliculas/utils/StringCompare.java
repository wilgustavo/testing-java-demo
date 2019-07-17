package com.peliculas.utils;

public class StringCompare {
	
	public static boolean contieneIngoreCase(String busqueda, String texto) {
		return texto.toUpperCase().contains(busqueda.toUpperCase());
	}

}
