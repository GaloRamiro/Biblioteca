package com.biblioteca;

public class Libro {

	// Datos principales del libro
	private int id;
	private String autor;
	private String genero;
	private String titulo;
	private int anio;
	private String isbn;
	private String editorial;
	private double precio;

	// Indica si el libro está prestado o disponible
	private boolean prestado;

	// Constructor vacío
	public Libro() {

	}

	// Constructor con ID y datos del libro
	public Libro(int id, String autor, String titulo, String genero, int anio, double precio) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.anio = anio;

		// Un libro nuevo comienza disponible
		this.prestado = false;
		this.precio = precio;
	}

	// Constructor sin ID
	public Libro(String autor, String titulo, String genero, int anio, double precio) {
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.anio = anio;

		// Un libro nuevo comienza disponible
		this.prestado = false;
		this.precio = precio;
	}

	// Getters y Setters
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	// Marca el libro como prestado
	public void prestar() {
		prestado = true;
	}

	// Devuelve el libro y cambia su estado a disponible
	public void devolverLibro() {

		// Solo se puede devolver si actualmente está prestado
		if (prestado == true) {
			prestado = false;
			System.out.println("libro devuelto");
		} else {
			System.out.println("libro NO se encuentra prestado");
		}
	}

	// Imprime únicamente el título del libro
	public void imprimir() {
		System.out.println("titulo= " + titulo);
	}

	// Convierte los datos del libro en texto para poder mostrarlos
	@Override
	public String toString() {
		return "Libro [id=" + id + ", autor=" + autor + ", genero=" + genero + ", titulo=" + titulo + ", anio=" + anio
				+ ", prestado=" + prestado + "]\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}