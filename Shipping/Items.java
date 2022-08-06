package object_oriented;

public class Items {
	
	private String item_name;
	private String shape;
	private double width;
	private double length;
	private double height;
	private double weight;
	private long N_Order;
	
	
	
	// CONSTRUCTORS
	public Items(String item_name, String shape, double width, double length, double height, double weight,
			long n_Order) {
		super();
		this.item_name = item_name;
		this.shape = shape;
		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight;
		N_Order = n_Order;
	}

	
	// GETTERS AND SETTERS
	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public long getN_Order() {
		return N_Order;
	}

	public void setN_Order(long n_Order) {
		N_Order = n_Order;
	}
	
	
	public double volume() {
		double volume = 0;
		if (this.shape == "cub") {
			volume = this.width * this.width * this.width;
		}
		if (this.shape == "cyl") {
			volume = Math.PI * (this.width/2) * (this.width/2) * this.height;
		}
		if (this.shape == "rect") {
			volume = this.width * this.length * this.height;
		}
		if (this.shape == "penta") {
			volume = 5 * this.height * this.width / 4;
		}
		return volume;
	}
	
	public double totalVolume() {
		double total_volume = this.volume() * this.N_Order;
		return total_volume;
	}
	
	public double totalWeight() {
		double total_weight = this.weight * this.N_Order;
		return total_weight;
	}
	
}
