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
   
    public NavigationServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buttonValue = request.getParameter("button");
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
	case "addManufacturer":
		request.getRequestDispatcher("pages/manufacturer.jsp").forward(request, response);
		break;
	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String buttonValue = request.getParameter("button");
switch (buttonValue) {
case "login":
	request.getRequestDispatcher("login").forward(request, response);
	break;
case "addCity":
	request.setAttribute("buttonName", "addCity");
	request.getRequestDispatcher("pages/city.jsp").forward(request, response);
	break;
case "showAllCity":
	request.getRequestDispatcher("pages/listCities.jsp").forward(request, response);
	break;
case "addManufacturer":
	request.setAttribute("buttonName", "addManufacturer");
	request.getRequestDispatcher("pages/manufacturer.jsp").forward(request, response);
	break;
case "showAllManufacturer":
	request.getRequestDispatcher("pages/listManufacturers.jsp").forward(request, response);
	break;
case "addProduct":
	request.setAttribute("buttonName", "addProduct");
	request.getRequestDispatcher("pages/product.jsp").forward(request, response);	
	break;
case "showAllProduct":
	request.getRequestDispatcher("pages/listProducts.jsp").forward(request, response);
	break;
}
	
	
	}
	
}
