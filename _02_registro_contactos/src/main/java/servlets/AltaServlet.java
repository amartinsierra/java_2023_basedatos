package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class AltaServlet
 */
@WebServlet("/AltaServlet")
public class AltaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=ContactosServiceFactory.getContactosService();
		//recogemos parámetros
		String nom=request.getParameter("nombre");
		String email=request.getParameter("email");
		int edad=Integer.parseInt(request.getParameter("edad"));
		//creamos el objeto contacto con los datos recibidos y llamamos al método de alta
		Contacto contacto=new Contacto(0, nom, email, edad);
		service.agregarContacto(contacto);
		//pasamos el control a la página de nuevo
		request.getRequestDispatcher("inicio.html").forward(request, response);
		
	}

}
