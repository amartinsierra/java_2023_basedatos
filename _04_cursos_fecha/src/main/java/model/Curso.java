package model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
	private int idCurso;
	private String nombre;
	private double precio;
	private int duracion;
	private LocalDate fechaInicio;
}
