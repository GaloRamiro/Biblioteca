package com.biblioteca;

import java.util.ArrayList;

public class Usuario {

	// Datos del usuario
	private String nombre;
	private String apellido;
	private String cedula;
	private int idUsuario;

	// Lista donde se guardan los libros que tiene prestados el usuario
	private ArrayList<Libro> librosPrestados;

	// Constructor vacío
	public Usuario() {
		// Se crea la lista vacía para evitar que sea null
		this.librosPrestados = new ArrayList<Libro>();
	}

	// Constructor con datos del usuario
	public Usuario(String nombre, String apellido, String cedula, int idUsuario) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.idUsuario = idUsuario;

		// Todo usuario nuevo empieza sin libros prestados
		this.librosPrestados = new ArrayList<Libro>();
	}

	// Retorna la lista de libros prestados
	public ArrayList<Libro> getLibrosPrestados() {
		return librosPrestados;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	// Agrega un libro a la lista de libros prestados
	public void tomarLibro(Libro libro) {
		librosPrestados.add(libro);
	}

	// Muestra los datos del usuario y sus libros prestados
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", idUsuario="
				+ idUsuario + ", \n librosPrestados=" + librosPrestados + "]";
	}

	// Quita el libro de la lista cuando el usuario lo devuelve
	public void devolverLibro(Libro libro) {
		librosPrestados.remove(libro);
	}

}