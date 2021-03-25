package engineering.it.web.servletzadatak.model;
 
public class Product {
private long id;
private String name;
private double pricePerUnit;
private String unit;
private String currency;
private double taxRate;
private Manufacturer manufacturer;
public Product() {
	// TODO Auto-generated constructor stub
}
public Product(long id, String name, double pricePerUnit, String unit, String currency, double taxRate,
		Manufacturer manufacturer) {
	super();
	this.id = id;
	this.name = name;
	this.pricePerUnit = pricePerUnit;
	this.unit = unit;
	this.currency = currency;
	this.taxRate = taxRate;
	this.manufacturer = manufacturer;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPricePerUnit() {
	return pricePerUnit;
}
public void setPricePerUnit(double pricePerUnit) {
	this.pricePerUnit = pricePerUnit;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public double getTaxRate() {
	return taxRate;
}
public void setTaxRate(double taxRate) {
	this.taxRate = taxRate;
}
public Manufacturer getManufacturer() {
	return manufacturer;
}
public void setManufacturer(Manufacturer manufacturer) {
	this.manufacturer = manufacturer;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", pricePerUnit=" + pricePerUnit + ", unit=" + unit + ", currency="
			+ currency + ", taxRate=" + taxRate + ", manufacturer=" + manufacturer + "]";
}

}
