package service;

import java.time.LocalDate;
import java.util.List;

import model.Curso;

public interface CursosService {
	List<Curso> cursosPorFechaInicioMax(LocalDate fechaLimite);
}
