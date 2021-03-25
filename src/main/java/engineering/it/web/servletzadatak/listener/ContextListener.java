package engineering.it.web.servletzadatak.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import engineering.it.web.servletzadatak.model.City;
import engineering.it.web.servletzadatak.model.User;
import engineering.it.web.servletzadatak.repositories.CityRepository;
import engineering.it.web.servletzadatak.repositories.UserRepository;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("=========================Metoda: Kontekst je inicijalizovan...=======================================");
    	List<User> listUsers = UserRepository.getInstance().getListUsers();
    	sce.getServletContext().setAttribute("listUsers", listUsers );
    	System.out.println("Ubaceni korisnici u listu:");
    	for (User u: listUsers)
    		System.out.println(u.getFirstname());
    	List<City> listCity = CityRepository.getInstance().getListCity();
    	sce.getServletContext().setAttribute("listCity", listCity );
    	System.out.println("Ubaceni gradovi u listu:");
    	for (City c: listCity)
    		System.out.println(c.getName());
    }
	
}
