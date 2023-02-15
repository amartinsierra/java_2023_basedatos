package service;

import java.util.ArrayList;
import java.util.List;

import model.Ciudad;

public class CiudadesService {
	static List<Ciudad> ciudades=new ArrayList<>(List.of(new Ciudad("Valladolid",230000,17.8),
			new Ciudad("Santander",100000,21.5),
			new Ciudad("Valencia",1230000,29.4),
			new Ciudad("Madrid",3230000,25.6),
			new Ciudad("Burgos",90000,11.8)));
	
	public List<Ciudad> todas(){
		return ciudades;
	}
	
	public void eliminarCiudad(String nombre) {
		ciudades.removeIf(c->c.getNombre().equals(nombre));
	}
}
