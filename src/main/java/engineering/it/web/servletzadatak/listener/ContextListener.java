package engineering.it.web.servletzadatak.listener;

import java.security.KeyStore.Entry;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import engineering.it.web.servletzadatak.model.City;
import engineering.it.web.servletzadatak.model.Manufacturer;
import engineering.it.web.servletzadatak.model.Product;
import engineering.it.web.servletzadatak.model.User;
import engineering.it.web.servletzadatak.repositories.CityRepository;
import engineering.it.web.servletzadatak.repositories.ManufacturerRepository;
import engineering.it.web.servletzadatak.repositories.ProductRepository;
import engineering.it.web.servletzadatak.repositories.UserRepository;

public class ContextListener implements ServletContextListener {

	public ContextListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		List<User> listUsers = UserRepository.getInstance().getListUsers();
		sce.getServletContext().setAttribute("listUsers", listUsers);
		List<City> listCity = CityRepository.getInstance().getListCity();
		sce.getServletContext().setAttribute("listCity", listCity);
		Map<String, Manufacturer> mapManufacturers = ManufacturerRepository.getInstance().getMapManufacturers();
		sce.getServletContext().setAttribute("mapManufacturers", mapManufacturers);
		Map<Long, Product> mapProducts = ProductRepository.getInstance().getMapProducts();
		sce.getServletContext().setAttribute("mapProducts", mapProducts);
	}

}
