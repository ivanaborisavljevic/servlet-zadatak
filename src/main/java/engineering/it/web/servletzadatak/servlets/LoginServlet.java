package engineering.it.web.servletzadatak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.servletzadatak.model.User;


@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		boolean success = false;
		List<User> listUsers = (List<User>)request.getServletContext().getAttribute("listUsers");
		for (User u :listUsers) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
			success = true;
			break;
			}
		}
		if (success == true) {
			request.getRequestDispatcher("pages/Home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Neuspesno logovanje, pogresan e-mail ili lozinka");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
