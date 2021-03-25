package engineering.it.web.servletzadatak.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.servletzadatak.model.City;

/**
 * Servlet implementation class AddCityServlet
 */
@WebServlet(urlPatterns = { "/addCity" })
public class AddCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCityServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		String indexParam = request.getParameter("index");
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
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Obradjujem post zahtev...");
		String name = request.getParameter("name");
		String postalCodeString = request.getParameter("postalCode");
		long postalCode = 0;
		boolean validation = true;
		City city = new City();
		if (name != null && postalCodeString != null) {
			try {
				postalCode = Long.parseLong(postalCodeString);
				for (City c : ((List<City>) request.getServletContext().getAttribute("listCity"))) {
					if (c.getName().equals(name)) {
					
						validation = false;
						System.out.println("A");
						request.setAttribute("errorCity", "Grad " + name + " vec postoji u listi gradova");
					}
					if (new Long(c.getPostalCode()).equals(new Long(postalCode))) {
						validation = false;
						System.out.println("B");
						request.setAttribute("errorCity",
								"Postanski broj " + postalCode + " vec postoji u listi gradova");
					}

				}
			} catch (NumberFormatException nfe) {
				validation = false;
				System.out.println("C");
				request.setAttribute("errorCity", "Postanski broj " + postalCodeString + " mora biti broj");

			}

		} else if (name == null) {
			validation = false;
			System.out.println("D");
			request.setAttribute("errorCity", "Morate uneti naziv grada");
		}
		if (postalCodeString == null) {
			validation = false;
			System.out.println("E");
			request.setAttribute("errorCity", "Morate uneti postanski broj");
		}

		if (validation) {
			System.out.println("validacija dobra");
			if (request.getParameter("button").equals("addCity")) {
				request.setAttribute("message", "Operacija cuvanja grada uspesna ...");
				city.setName(name);
				city.setPostalCode(postalCode);
				saveOperation(city, request);

			}else if (request.getParameter("button").equals("updateCity")) {
				request.setAttribute("message", "Operacija update grada uspesna ...");
				int index = Integer.parseInt(request.getParameter("index"));
				updateOperation(index,name,postalCode, request);

			}
		} else {
			request.setAttribute("message", "Greska pri unosu...");
		}

	}

	private void updateOperation(int index, String name, long postalCode, HttpServletRequest request) {
		List<City> listCity = (List<City>) request.getServletContext().getAttribute("listCity");
		System.out.println("Uslo u update operatin");
		City city =listCity.get(index);
		city.setName(name);
		city.setPostalCode(postalCode);
		System.out.println("Svi gradovi posle update:");
		System.out.println(listCity);

	}

	private void saveOperation(City city, HttpServletRequest request) {
		List<City> listCity = (List<City>) request.getServletContext().getAttribute("listCity");
		listCity.add(city);
		System.out.println("Svi gradovi posle unosa:");
		System.out.println(listCity);
	}

}
