package engineering.it.web.servletzadatak.model;

public class Manufacturer {
private long PIB;
private long companyNumber;
private String name;
private String address;
private City city;
public Manufacturer() {
	// TODO Auto-generated constructor stub
}
public Manufacturer(long PIB, String address, long companyNumber, String name, City city) {
	super();
	this.PIB = PIB;
	this.address = address;
	this.companyNumber = companyNumber;
	this.name = name;
	this.city = city;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPIB() {
	return PIB;
}
public void setPIB(long pIB) {
	PIB = pIB;
}
public long getCompanyNumber() {
	return companyNumber;
}
public void setCompanyNumber(long companyNumber) {
	this.companyNumber = companyNumber;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public City getCity() {
	return city;
}
public void setCity(City city) {
	this.city = city;
}
@Override
public String toString() {
	return "Manufacturer [PIB=" + PIB + ", companyNumber=" + companyNumber + ", name=" + name + ", city=" + city + "]";
}


}
