package service;

import java.util.List;

import model.Libro;
import model.Tema;

public interface LibrosService {
	List<Libro> libros();
	List<Tema> temas();
}
