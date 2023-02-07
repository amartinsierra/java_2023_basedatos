package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class ModificarServlet
 */
@WebServlet("/ModificarServlet")
public class ModificarServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=ContactosServiceFactory.getContactosService();
		//recogemos parámetros
		String nom=request.getParameter("nombre");
		String email=request.getParameter("email");
		service.modificarEmail(nom, email);
		//pasamos el control a la página de nuevo
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
