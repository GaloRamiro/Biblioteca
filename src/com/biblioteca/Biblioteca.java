package com.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

	// Lista donde se guardan todos los libros de la biblioteca
	private ArrayList<Libro> libros;

	// Constructor vacío: crea una lista de libros vacía
	public Biblioteca() {
		this.libros = new ArrayList<Libro>();
	}

	// Constructor que recibe una lista de libros existente
	public Biblioteca(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	// Retorna la lista completa de libros
	public ArrayList<Libro> getLibros() {
		return libros;
	}

	// Reemplaza la lista de libros
	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	// Agrega un libro a la biblioteca
	public void agregarLibro(Libro libro) {

		// Valida que el libro recibido no sea null
		if (libro == null) {
			System.out.println("Libro no es valido para ingresar");
			return;
		}

		// Si no tiene ID, se genera uno según el tamaño de la lista
		if (libro.getId() <= 0) {
			libro.setId(libros.size() + 1);
		}

		// Agrega el libro a la lista
		libros.add(libro);
	}

	// Elimina un libro utilizando el objeto Libro
	public void eliminarLibro(Libro libro) {

		// Busca la posición del libro dentro de la lista
		int indice = obtenerIndice(libro);

		// -1 significa que el libro no fue encontrado
		if (indice == -1) {
			System.out.println("No exite libro para eliminar");
			return;
		}

		// Elimina el libro encontrado
		libros.remove(indice);
	}

	// Elimina un libro utilizando su posición en la lista
	public Libro eliminarLibro(int indice) {

		Libro libro = null;

		// Valida que el índice exista dentro de la lista
		if (indice < 0 || indice >= libros.size()) {
			System.out.println("Indice no es correcto");
			return libro;
		}

		// Obtiene el libro antes de eliminarlo
		libro = libros.get(indice);

		// Elimina el libro de la lista
		libros.remove(indice);

		// Devuelve el libro que fue eliminado
		return libro;
	}

	// Busca la posición de un libro utilizando su ID
	public int obtenerIndice(Libro libro) {

		// -1 indica que todavía no se encontró
		int indice = -1;

		// Si el libro es null, no se puede buscar
		if (libro == null) {
			return indice;
		}

		// Recorre toda la lista de libros
		for (int i = 0; i < libros.size(); i++) {

			// Compara el ID del libro de la lista con el recibido
			if (libros.get(i).getId() == libro.getId()) {
				indice = i;

				// Detiene el for porque el libro ya fue encontrado
				break;
			}
		}

		return indice;
	}

	// Presta un libro a un usuario
	public void prestarLibro(Libro libro, Usuario usuario) {

		// Verifica la cantidad de libros que ya tiene el usuario
		if (usuario.getLibrosPrestados().size() > 3) {
			System.out.println("NO PUEDES PEDIR MAS DE 3");
			return;
		}

		// Recorre los libros de la biblioteca
		for (int i = 0; i < libros.size(); i++) {

			// Busca el libro por su ID
			if (libros.get(i).getId() == libro.getId()) {

				// Comprueba si el libro ya está prestado
				if (libros.get(i).isPrestado()) {
					System.out.println("Lo sentimos no se puede prestar");
					return;
				}

				// Cambia el estado del libro a prestado
				libros.get(i).prestar();

				// Agrega el libro a los libros prestados del usuario
				usuario.tomarLibro(libro);
			}
		}
	}

	// Busca un libro por su ID
	public Libro buscarPorId(int id) {

		// Recorre directamente cada libro de la lista
		for (Libro libro : libros) {

			if (libro.getId() == id) {
				return libro;
			}
		}

		// Si no encuentra el libro devuelve null
		return null;
	}

	// Busca un libro por su título
	public Libro buscarPorTitulo(String titulo) {

		for (Libro libro : libros) {

			// Ignora diferencias entre mayúsculas y minúsculas
			if (libro.getTitulo().equalsIgnoreCase(titulo)) {
				return libro;
			}
		}

		return null;
	}

	// Muestra los libros que se encuentran disponibles
	public void mostrarLibrosDisponibles() {

		for (Libro libro : libros) {

			// ! significa NO: entra si el libro NO está prestado
			if (!libro.isPrestado()) {
				System.out.println(libro);
			} else {
				System.out.println("Libro no disponible");
			}
		}
	}

	// Busca y muestra libros de un autor
	public void buscarPorAutor(String nombreAutor) {

		// Sirve para saber si se encontró al menos un resultado
		boolean encontrado = false;

		for (Libro libro : libros) {

			if (libro.getAutor().equalsIgnoreCase(nombreAutor)) {
				System.out.println(libro);
				encontrado = true;
			}
		}

		// Se ejecuta si ningún libro coincidió
		if (!encontrado) {
			System.out.println("No se encontraron libros de este AUTOR");
		}
	}

	// Muestra libros cuyo precio sea menor o igual al precio máximo
	public void buscarPrecioMaximo(double precioMaximo) {

		boolean encontrado = false;

		for (Libro libro : libros) {

			if (libro.getPrecio() <= precioMaximo) {
				System.out.println(libro);
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontraron libros dentro de ese precio");
		}
	}

	// Muestra libros cuyo precio sea mayor o igual al precio mínimo
	public void buscarPrecioMinimo(double precioMinimo) {

		boolean encontrado = false;

		for (Libro libro : libros) {

			if (libro.getPrecio() >= precioMinimo) {
				System.out.println(libro);
				encontrado = true;
			}

			if (!encontrado) {
				System.out.println("No se encontraron libros menores al precio deseado");
			}
		}
	}

	// Busca libros cuyo autor contenga una palabra o cadena
	public ArrayList<Libro> buscarPorCadena(String cadena) {

		// Lista donde se guardarán las coincidencias
		ArrayList<Libro> lista = new ArrayList<Libro>();

		for (Libro libro : libros) {

			// Convierte ambos textos a minúsculas para facilitar la comparación
			if (libro.getAutor().toLowerCase().contains(cadena.toLowerCase())) {

				// Agrega el libro encontrado a la nueva lista
				lista.add(libro);
			}
		}

		// isEmpty verifica si la lista está vacía
		if (lista.isEmpty()) {
			System.out.println("No hay resultados");
		}

		// Devuelve todos los libros encontrados
		return lista;
	}

}