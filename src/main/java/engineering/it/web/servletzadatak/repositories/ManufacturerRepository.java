package engineering.it.web.servletzadatak.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engineering.it.web.servletzadatak.listener.ContextListener;
import engineering.it.web.servletzadatak.model.City;
import engineering.it.web.servletzadatak.model.Manufacturer;

public class ManufacturerRepository {
	 private static final ManufacturerRepository INSTANCE = new ManufacturerRepository();
		
	 Map<String, Manufacturer> mapManufacturers = Collections.synchronizedMap(new HashMap<String, Manufacturer>());
	 
		

		public ManufacturerRepository() {
			initializeList();
		}
		public static ManufacturerRepository getInstance() {
			return INSTANCE;
		}

		public Map<String, Manufacturer> getMapManufacturers() {
			return mapManufacturers;
		}

		public void setMapManufacturers(Map<String, Manufacturer> mapManufacturers) {
			this.mapManufacturers = mapManufacturers;
		}

		public void initializeList() {
			ContextListener cl = new ContextListener();
	    	List<City> listCity = CityRepository.getInstance().getListCity();

			mapManufacturers.put("Proizvodjac 1", new Manufacturer(162711, "adresa1",16271, "Proizvodjac 1", listCity.get(0)));
			mapManufacturers.put("Proizvodjac 2", new Manufacturer(162715,"adresa2", 17271, "Proizvodjac 2", listCity.get(1)));
			mapManufacturers.put("Proizvodjac 3", new Manufacturer(162791, "adresa3",19271, "Proizvodjac 3", listCity.get(1)));
		}

}
