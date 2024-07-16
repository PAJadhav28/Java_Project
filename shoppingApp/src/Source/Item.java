package Source;

import java.io.Serializable;

/**
 * The class used to represent the main entity Item from the application
 */
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;

	public Item(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Item{" + "id=" + id + ", name='" + name + '\'' + ", Price='" + price + '\'' + '}';
	}
}