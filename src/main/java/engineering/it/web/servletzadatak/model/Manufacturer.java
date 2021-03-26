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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (PIB ^ (PIB >>> 32));
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + (int) (companyNumber ^ (companyNumber >>> 32));
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Manufacturer other = (Manufacturer) obj;
	if (PIB != other.PIB)
		return false;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (companyNumber != other.companyNumber)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}


}
