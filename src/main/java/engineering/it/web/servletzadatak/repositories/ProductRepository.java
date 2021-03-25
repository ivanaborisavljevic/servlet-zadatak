package engineering.it.web.servletzadatak.repositories;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import engineering.it.web.servletzadatak.listener.ContextListener;
import engineering.it.web.servletzadatak.model.City;
import engineering.it.web.servletzadatak.model.Manufacturer;
import engineering.it.web.servletzadatak.model.Product;

public class ProductRepository {
	 private static final ProductRepository INSTANCE = new ProductRepository();
		
	 Map<Long, Product> mapProducts = Collections.synchronizedMap(new HashMap<Long, Product>());
	 
		

		public ProductRepository() {
			initializeList();
		}
		public static ProductRepository getInstance() {
			return INSTANCE;
		}

		public Map<Long, Product> getMapProducts() {
			return mapProducts;
		}

		public void setMapProducts(Map<Long,Product> mapProducts) {
			this.mapProducts = mapProducts;
		}

		public void initializeList() {
			ContextListener cl = new ContextListener();
	    	Map<String,Manufacturer> mapManufacturers = ManufacturerRepository.getInstance().getMapManufacturers();

			mapProducts.put((long) 34321, new Product(34321, "proizvod1", 20.0, "kg", "din", 0.15, mapManufacturers.get("Proizvodjac 1")));
			mapProducts.put((long)62732,new Product(62732, "proizvod2", 34.0, "m", "euro", 0.45, mapManufacturers.get("Proizvodjac 2")));
			mapProducts.put((long)7283, new Product(7283, "proizvod3", 37.0, "t", "euro", 0.30, mapManufacturers.get("Proizvodjac 2")));
		}
}
