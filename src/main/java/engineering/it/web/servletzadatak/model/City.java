package engineering.it.web.servletzadatak.model;

public class City {
private long postalCode;
private String name;
public City() {
	// TODO Auto-generated constructor stub
}
public City(long postalCode, String name) {
	super();
	this.postalCode = postalCode;
	this.name = name;
}
public long getPostalCode() {
	return postalCode;
}
public void setPostalCode(long postalCode) {
	this.postalCode = postalCode;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "City [postalCode=" + postalCode + ", name=" + name + "]";
}

}
