package engineering.it.web.servletzadatak.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
		
		@SuppressWarnings("unchecked")
		List<City> listCity = ((List<City>)request.getServletContext().getAttribute("listCity"));
		City city = listCity.get(id);
		switch (name) {
		
		case "delete":
			if (validateDeleteCity(request, city)) {
				request.setAttribute("message", "Successfully deleted city "+city.getName());
				listCity.remove(id);
			}
			else {
				request.setAttribute("message", "Cannot delete "+city.getName()+ " because a manufacturer has this city");
			}
			
			request.getRequestDispatcher("pages/listCities.jsp").forward(request, response);
			break;
		case "update":
			request.setAttribute("city", city);
			request.setAttribute("buttonName", "updateCity");
			request.setAttribute("id", id);
			request.getRequestDispatcher("pages/city.jsp").forward(request, response);
			break;

		case "show":
			request.setAttribute("city", city);
			request.setAttribute("buttonName", "showCity");
			request.getRequestDispatcher("pages/city.jsp").forward(request, response);
			break;

		}
		
		
		
	
		}

	private boolean validateDeleteCity(HttpServletRequest request, City city) {
		@SuppressWarnings("unchecked")
		Map<String,Manufacturer> mapManufacturers = (Map<String,Manufacturer>)request.getServletContext().getAttribute("mapManufacturers");
		for (Entry<String,Manufacturer> e: mapManufacturers.entrySet())
			if (e.getValue().getCity().equals(city))
				return false;
		return true;
	
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
			
			int id = Integer.parseInt(request.getParameter("id"));
			city = listCity.get(id);
			
			String name = request.getParameter("name");
			String postalCodeStr = request.getParameter("postalCode");
			
			if (postalCodeStr==null || postalCodeStr.equals(""))

			{
				request.setAttribute("message", "Postal code must be number and not empty!");
				request.setAttribute("city", city);
				request.setAttribute("id", id);
				request.setAttribute("buttonName", "updateCity");
				
				request.getRequestDispatcher("/pages/city.jsp").forward(request, response);
				break;
			}
			long postalCode=0;
			try {
			postalCode =Long.parseLong(postalCodeStr);
			}
			catch (NumberFormatException nfe) {
				request.setAttribute("message", "Postal code must be number!");
				request.setAttribute("city", city);
				request.setAttribute("id", id);
				request.setAttribute("buttonName", "updateCity");
				request.getRequestDispatcher("pages/city.jsp").forward(request, response);
				break;
			}
			if (validateUpdateCity(request, name, postalCode, city)) {
			city.setName(name);
			city.setPostalCode(postalCode);
			request.setAttribute("message", "Successfully updated city ");
			}
			else {
				request.setAttribute("city", city);
				request.setAttribute("id", id);
				request.setAttribute("buttonName", "updateCity");
				request.getRequestDispatcher("pages/city.jsp").forward(request, response);
				break;
			}
			
			request.getRequestDispatcher("pages/listCities.jsp").forward(request, response);
				break;
			
		}

}

	private boolean validateUpdateCity(HttpServletRequest request, String name, long postalCode, City city) {
		if (name==null|| name.equals("")) {
			request.setAttribute("message", "City name cannot be empty");
			return false;
		}
		
		List<City> listCity = (List<City>) request.getServletContext().getAttribute("listCity");
		for (City c: listCity) {
			if (c==city)
				continue;
			if (c.getName().equals(name)) {
				request.setAttribute("message", "City with name  "+name+" already exists");
				return false;
			}
			if (c.getPostalCode()==postalCode) {
				request.setAttribute("message", "City with postal code  "+postalCode+" already exists");
				return false;
			}
			
		}
		return true;
		
	}
}
