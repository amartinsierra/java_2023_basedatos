package service;

import java.util.List;

public interface ItemsService {
	List<String> paises();
	double incidenciaPais(String pais);
	int totalAcumulados();
}
