package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contacto;
import service.ContactosService;
import service.ContactosServiceFactory;

/**
 * Servlet implementation class ContactosServlet
 */
@WebServlet("/ContactosServlet")
public class ContactosServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactosService service=ContactosServiceFactory.getContactosService();
		List<Contacto> contactos=service.contactos();
		request.setAttribute("contactos", contactos);
		request.getRequestDispatcher("contactos.jsp").forward(request, response);
	}

}
