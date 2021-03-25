package engineering.it.web.servletzadatak.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet (urlPatterns = {"/navigation"})
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonValue = request.getParameter("button");
		System.out.println("Button value:"+buttonValue);
		////////////////////////////////////////////////////////////////////	
	switch (buttonValue) {
	case "login":
		request.getRequestDispatcher("login").forward(request, response);
		break;
	case "addCity":
		request.getRequestDispatcher("pages/addCity.jsp").forward(request, response);
		break;
	case "showAllCity":
		request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
		break;
	case "deleteCity":
		request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
		break;
	case "showCity":
		request.getRequestDispatcher("pages/showCity.jsp").forward(request, response);
		break;
	case "updateCity":
		request.getRequestDispatcher("pages/updateCity.jsp").forward(request, response);
		break;
	}

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String buttonValue = request.getParameter("button");
	System.out.println("Button value:"+buttonValue);
	////////////////////////////////////////////////////////////////////	
switch (buttonValue) {
case "login":
	request.getRequestDispatcher("login").forward(request, response);
	break;
case "addCity":
	request.getRequestDispatcher("pages/addCity.jsp").forward(request, response);
	break;
case "showAllCity":
	request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
	break;
case "deleteCity":
	request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
	break;
case "showCity":
	request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
	break;
case "updateCity":
	request.getRequestDispatcher("pages/listCity.jsp").forward(request, response);
	break;
}
	
	
	}
	
}
