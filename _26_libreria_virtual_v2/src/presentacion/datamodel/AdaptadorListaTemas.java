package presentacion.datamodel;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import model.Tema;
import service.LibreriaServiceFactory;
import service.LibrosService;

public class AdaptadorListaTemas extends DefaultComboBoxModel<Tema>{
	List<Tema> temas;
	public AdaptadorListaTemas() {
		LibrosService service=LibreriaServiceFactory.getLibrosService();
		temas=service.temas();
	}
	@Override
	public int getSize() {
		return temas.size();
	}
	@Override
	public Tema getElementAt(int index) {
		return temas.get(index);
	}
	
	
}
