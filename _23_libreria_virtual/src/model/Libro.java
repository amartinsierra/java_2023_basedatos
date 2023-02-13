package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
	private int isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private int idTema;
}
