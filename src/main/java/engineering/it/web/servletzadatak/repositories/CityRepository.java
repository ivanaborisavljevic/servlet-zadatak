package engineering.it.web.servletzadatak.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engineering.it.web.servletzadatak.model.City;

public class CityRepository {
	    private static final CityRepository INSTANCE = new CityRepository();
		List<City> listCity = Collections.synchronizedList(new ArrayList<City>());

		public CityRepository() {
			initializeList();
		}
		public static CityRepository getInstance() {
			return INSTANCE;
		}

		public List<City> getListCity() {
			return listCity;
		}

		public void setListCity(List<City> listCity) {
			this.listCity = listCity;
		}

		public void initializeList() {
			listCity.add(new City(11000, "Beograd"));
			listCity.add(new City(21000, "Novi Sad"));
			listCity.add(new City(34000, "Kragujevac"));
		}
}
