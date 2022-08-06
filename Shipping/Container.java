package Shipping;

public class Container {
	
	private double height;
	private double width;
	private double length;
	private double price;
	
	//constructor
	
	Container(double length) {
		this.height = 2.59;
		this.width = 2.43;
		this.length = length;
		this.price = 0; // Initialize in the main class
	}
	
	//getter and setter
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//method
	
	double calculateVolume() {
		double volume;
		volume = this.height * this.width * this.length;
		return volume;
	}
	
}