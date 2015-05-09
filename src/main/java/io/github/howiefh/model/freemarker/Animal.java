package io.github.howiefh.model.freemarker;

public class Animal {

	private String name;
	private double price;
	private boolean protect;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isProtect() {
		return protect;
	}

	public void setProtect(boolean protect) {
		this.protect = protect;
	}
	
	public Animal() {
	}

	public Animal(String name, double price, boolean protect) {
		super();
		this.name = name;
		this.price = price;
		this.protect = protect;
	}
	
}
