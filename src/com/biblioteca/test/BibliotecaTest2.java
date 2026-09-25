package com.biblioteca.test;

import java.util.ArrayList;

import com.biblioteca.Biblioteca;
import com.biblioteca.Libro;

public class BibliotecaTest2 {

	public static void main(String[] args) {

		System.out.println("========================================");
		System.out.println("        PRUEBAS BIBLIOTECA 2");
		System.out.println("========================================");

		// Crear libros
		Libro l1 = new Libro(
				"JJ benitez",
				"Caballo de troya",
				"",
				2010,
				21.00
		);

		Libro l2 = new Libro(
				2,
				"Gabriel Garcia Marquez",
				"Caballo de troya",
				"",
				2010,
				21.00
		);

		Libro l3 = new Libro(
				"Maria Fernanda Heredia",
				"Caballo de troya",
				"",
				2010,
				21.00
		);

		Libro l4 = new Libro(
				4,
				"Homero",
				"Caballo de troya",
				"",
				2010,
				21.00
		);

		Libro l5 = new Libro(
				"Benitez",
				"Caballo de troya",
				"",
				2010,
				21.00
		);

		// Crear biblioteca
		Biblioteca b1 = new Biblioteca();

		// Agregar libros a la biblioteca
		b1.agregarLibro(l1);
		b1.agregarLibro(l2);
		b1.agregarLibro(l3);
		b1.agregarLibro(l4);
		b1.agregarLibro(l5);


		// Mostrar libros registrados
		System.out.println("\n========================================");
		System.out.println("          LIBROS REGISTRADOS");
		System.out.println("========================================");

		for (Libro libro : b1.getLibros()) {

			System.out.println(
					"ID: " + libro.getId()
					+ " | Autor: " + libro.getAutor()
					+ " | Título: " + libro.getTitulo()
					+ " | Precio: $" + libro.getPrecio()
			);
		}

		System.out.println("\nTotal de libros: " + b1.getLibros().size());


		// Buscar libros por una cadena
		System.out.println("\n========================================");
		System.out.println("          BÚSQUEDA POR CADENA");
		System.out.println("========================================");

		String cadenaBuscar = "";

		System.out.println("Cadena buscada: \"" + cadenaBuscar + "\"");

		ArrayList<Libro> libros = b1.buscarPorCadena(cadenaBuscar);

		System.out.println("Resultados encontrados: " + libros.size());

		for (Libro libro : libros) {
			System.out.println(
					"- ID: " + libro.getId()
					+ " | " + libro.getAutor()
					+ " | " + libro.getTitulo()
			);
		}


		// Pruebas de eliminación
		System.out.println("\n========================================");
		System.out.println("          ELIMINAR REGISTROS");
		System.out.println("========================================");

		System.out.println(
				"Cantidad inicial: " + b1.getLibros().size()
		);


		// Intentar eliminar utilizando un Libro nuevo
		System.out.println("\n--- Eliminar con new Libro() ---");

		b1.eliminarLibro(new Libro());

		System.out.println(
				"Cantidad después del intento: "
				+ b1.getLibros().size()
		);


		// Intentar eliminar enviando null
		System.out.println("\n--- Eliminar utilizando null ---");

		b1.eliminarLibro(null);

		System.out.println(
				"Cantidad después del intento: "
				+ b1.getLibros().size()
		);


		// Eliminar utilizando la posición del libro
		System.out.println("\n--- Eliminar utilizando índice ---");

		int indiceEliminar = 2;

		System.out.println("Índice a eliminar: " + indiceEliminar);

		Libro libroEliminado = b1.eliminarLibro(indiceEliminar);

		System.out.println(
				"Cantidad después de eliminar: "
				+ b1.getLibros().size()
		);

		// Mostrar información del libro eliminado
		if (libroEliminado != null) {

			System.out.println("Libro eliminado:");
			System.out.println("ID: " + libroEliminado.getId());
			System.out.println("Título: " + libroEliminado.getTitulo());
			System.out.println("Autor: " + libroEliminado.getAutor());

		} else {

			System.out.println("No se eliminó ningún libro");
		}


		// Mostrar estado final de la biblioteca
		System.out.println("\n========================================");
		System.out.println("        BIBLIOTECA DESPUÉS DE ELIMINAR");
		System.out.println("========================================");

		for (Libro libro : b1.getLibros()) {

			System.out.println(
					"ID: " + libro.getId()
					+ " | Autor: " + libro.getAutor()
					+ " | Título: " + libro.getTitulo()
			);
		}

		System.out.println("\nTotal final: " + b1.getLibros().size());

		System.out.println("\n========================================");
		System.out.println("            FIN DE PRUEBAS");
		System.out.println("========================================");
	}

}