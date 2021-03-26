package engineering.it.web.servletzadatak.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.servletzadatak.model.City;
import engineering.it.web.servletzadatak.model.Manufacturer;

/**
 * Servlet implementation class AddCityServlet
 */
//@WebServlet(urlPatterns = { "/addCity" })
@WebServlet(urlPatterns = { "/city" })
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String name = request.getParameter("name");
		int id = Integer.parseInt(request.getParameter("element"));
		
		List<City> listCity = ((List<City>)request.getServletContext().getAttribute("listCity"));
		City city = listCity.get(id);
		switch (name) {
		
		case "delete":
			listCity.remove(id);
			request.getRequestDispatcher("pages/listCities.jsp").forward(request, response);
			break;
		case "update":
			request.setAttribute("city", city);
			request.setAttribute("buttonName", "updateCity");
			request.setAttribute("idCity", id);
			request.getRequestDispatcher("pages/city.jsp").forward(request, response);
			break;

		case "show":
			request.setAttribute("city", city);
			request.setAttribute("buttonName", "showCity");
			request.getRequestDispatcher("pages/city.jsp").forward(request, response);
			break;

		}
		
		
		
		// TODO Auto-generated method stub
	/*	String indexParam = request.getParameter("index");
		String operation = request.getParameter("name");
		int index = Integer.parseInt(indexParam);
		List<City> list = (List<City>) request.getServletContext().getAttribute("listCity");
		City city = list.get(index);

		switch(operation) {

		case "delete":
		list.remove(index);
		request.getRequestDispatcher("/navigation?button=showAllCity").forward(request, response);	
		break;
		
		case "show":
		
		request.setAttribute("city", city);
		request.getRequestDispatcher("/navigation?button=showCity").forward(request, response);
			break;
		case "update":	
			request.setAttribute("city", city);
			request.setAttribute("index", index);
			request.setAttribute("button", "updateCity");
			System.out.println("INDEKS JE:"+index);
			
			request.getRequestDispatcher("/navigation?button=updateCity").forward(request, response);
			break;
		
		}
	*/	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonValue = request.getParameter("button");
		
        List<City> listCity = ((List<City>)request.getServletContext().getAttribute("listCity"));
        City city = new City();		
		switch (buttonValue){
		
		
		case "addCity":
		city.setPostalCode(Long.parseLong(request.getParameter("postalCode")));
		city.setName(request.getParameter("name"));
		listCity.add(city);
	
		
		request.setAttribute("message", "Successfully added city");
		request.getRequestDispatcher("pages/city.jsp").forward(request, response);;
			break;
			
		case "updateCity":
			city = listCity.get(Integer.parseInt(request.getParameter("id")));
			
			city.setName(request.getParameter("name"));
			city.setPostalCode(Long.parseLong(request.getParameter("postalCode")));
			
			
			request.setAttribute("message", "Successfully updated city");
			request.getRequestDispatcher("pages/listCities.jsp").forward(request, response);;
				break;
			
		}

}
}
