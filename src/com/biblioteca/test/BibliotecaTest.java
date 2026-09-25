package com.biblioteca.test;

import com.biblioteca.Biblioteca;
import com.biblioteca.Libro;
import com.biblioteca.Usuario;

public class BibliotecaTest {

	public static void main(String[] args) {

		System.out.println("========================================");
		System.out.println("       SISTEMA DE BIBLIOTECA");
		System.out.println("========================================");

		// Crear biblioteca
		Biblioteca biblioteca = new Biblioteca();

		System.out.println("\n--- BIBLIOTECA INICIAL ---");
		System.out.println("Cantidad de libros: " + biblioteca.getLibros().size());


		// Crear primer libro
		Libro libro1 = new Libro(
				1,
				"JJ Benites",
				"Harry Potter",
				"Aventura",
				1997,
				12.00
		);

		// Crear usuario
		Usuario usuario1 = new Usuario(
				"Addonys",
				"Herrera",
				"1723879662",
				1
		);

		System.out.println("\n--- USUARIO REGISTRADO ---");
		System.out.println("Nombre: " + usuario1.getNombre());
		System.out.println("Apellido: " + usuario1.getApellido());
		System.out.println("Cédula: " + usuario1.getCedula());
		System.out.println("ID: " + usuario1.getIdUsuario());


		// Agregar primer libro
		biblioteca.agregarLibro(libro1);

		System.out.println("\n--- LIBRO AGREGADO ---");
		System.out.println("Título: " + libro1.getTitulo());
		System.out.println("Autor: " + libro1.getAutor());
		System.out.println("Precio: $" + libro1.getPrecio());


		// Prestar primer libro
		System.out.println("\n--- PRÉSTAMO DE LIBRO ---");

		biblioteca.prestarLibro(libro1, usuario1);

		System.out.println("Libro prestado: " + libro1.getTitulo());
		System.out.println("Usuario: " + usuario1.getNombre());
		System.out.println("Total prestados: "
				+ usuario1.getLibrosPrestados().size());


		// Crear segundo libro
		Libro libro2 = new Libro(
				2,
				"Brandon Leon",
				"1984",
				"Politica",
				1949,
				29.99
		);

		biblioteca.agregarLibro(libro2);


		// Crear tercer libro
		Libro libro3 = new Libro(
				3,
				"Jane Austen",
				"Orgullo y Prejuicio",
				"Romance",
				1813,
				26.50
		);

		biblioteca.agregarLibro(libro3);


		// Crear cuarto libro
		Libro libro4 = new Libro(
				4,
				"José Saramago",
				"Ensayo sobre la ceguera",
				"Novela",
				1995,
				80.50
		);

		biblioteca.agregarLibro(libro4);


		System.out.println("\n========================================");
		System.out.println("        LIBROS REGISTRADOS");
		System.out.println("========================================");

		for (Libro libro : biblioteca.getLibros()) {

			System.out.println(
					"ID: " + libro.getId()
					+ " | Título: " + libro.getTitulo()
					+ " | Autor: " + libro.getAutor()
					+ " | Precio: $" + libro.getPrecio()
					+ " | Prestado: " + libro.isPrestado()
			);
		}


		// Prestar más libros
		biblioteca.prestarLibro(libro3, usuario1);
		biblioteca.prestarLibro(libro4, usuario1);


		System.out.println("\n========================================");
		System.out.println("        LIBROS DEL USUARIO");
		System.out.println("========================================");

		for (Libro libro : usuario1.getLibrosPrestados()) {
			System.out.println(
					"- " + libro.getTitulo()
					+ " | " + libro.getAutor()
			);
		}


		// Buscar libro por ID
		System.out.println("\n========================================");
		System.out.println("        BUSCAR LIBRO POR ID");
		System.out.println("========================================");

		int idBuscar = 10;

		Libro encontrado = biblioteca.buscarPorId(idBuscar);

		System.out.println("Buscando ID: " + idBuscar);

		if (encontrado != null) {
			System.out.println("Encontrado: " + encontrado.getTitulo());
			System.out.println("Autor: " + encontrado.getAutor());
		} else {
			System.out.println("Libro no encontrado");
		}


		// Buscar libro por título
		System.out.println("\n========================================");
		System.out.println("       BUSCAR LIBRO POR TÍTULO");
		System.out.println("========================================");

		String tituloBuscar = "frs";

		Libro libroEncontrado =
				biblioteca.buscarPorTitulo(tituloBuscar);

		System.out.println("Buscando: " + tituloBuscar);

		if (libroEncontrado != null) {
			System.out.println(
					"Encontrado: " + libroEncontrado.getTitulo()
			);
			System.out.println(
					"Autor: " + libroEncontrado.getAutor()
			);
		} else {
			System.out.println("Libro no encontrado");
		}


		// Mostrar libros disponibles
		System.out.println("\n========================================");
		System.out.println("        LIBROS DISPONIBLES");
		System.out.println("========================================");

		biblioteca.mostrarLibrosDisponibles();


		// Buscar por autor
		System.out.println("\n========================================");
		System.out.println("          BUSCAR POR AUTOR");
		System.out.println("========================================");

		biblioteca.buscarPorAutor("josé saramago");


		// Buscar por precio máximo
		System.out.println("\n========================================");
		System.out.println("        PRECIO MÁXIMO: $10");
		System.out.println("========================================");

		biblioteca.buscarPrecioMaximo(10);


		// Buscar por precio mínimo
		System.out.println("\n========================================");
		System.out.println("        PRECIO MÍNIMO: $90");
		System.out.println("========================================");

		biblioteca.buscarPrecioMinimo(90);


		System.out.println("\n========================================");
		System.out.println("          FIN DE LA PRUEBA");
		System.out.println("========================================");
	}

}