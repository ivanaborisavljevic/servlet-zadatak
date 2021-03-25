package engineering.it.web.servletzadatak.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import engineering.it.web.servletzadatak.model.User;

public class UserRepository {
    private static final UserRepository INSTANCE = new UserRepository();
	List<User> listUsers = Collections.synchronizedList(new ArrayList<User>());

	public UserRepository() {
		initializeList();
	}
	public static UserRepository getInstance() {
		return INSTANCE;
	}

	public List<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(List<User> listUsers) {
		this.listUsers = listUsers;
	}

	public void initializeList() {
		listUsers.add(new User("Mika", "Mikic", "mika@gmail.com", "mika"));
		listUsers.add(new User("Pera", "Peric", "pera@gmail.com", "pera"));
		listUsers.add(new User("Laza", "Lazic", "laza@gmail.com", "laza"));
	}
}
