package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.CursosService;
import service.CursosServiceFactory;

/**
 * Servlet implementation class CursosFechaServlet
 */
@WebServlet("/CursosFechaServlet")
public class CursosFechaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=CursosServiceFactory.getCursosService();
		String f=request.getParameter("fecha");
		LocalDate fecha=LocalDate.parse(f); //válido si el formato es yyyy-MM-dd
		List<Curso> cursos=service.cursosPorFechaInicioMax(fecha);
		request.setAttribute("cursos", cursos);
		request.getRequestDispatcher("cursos.jsp").forward(request, response);
	}

}
