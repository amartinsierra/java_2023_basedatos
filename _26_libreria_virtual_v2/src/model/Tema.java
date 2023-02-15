package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tema {
	private int idTema;
	private String tematica;
	
	@Override
	public String toString() {
		return tematica;
	}
}
