package service;

import java.util.List;

import model.Contacto;

public interface ContactosService {

	void agregarContacto(Contacto contacto);
	void eliminarContacto(String nombre);
	void modificarEmail(String nombre, String nuevoEmail);
	
	List<Contacto> contactos();

}