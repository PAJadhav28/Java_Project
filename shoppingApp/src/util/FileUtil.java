package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Source.Cart;
import Source.Item;
import Source.Stock;
/**
 * The class FileUtil defined the different static methods used to perform the different operations on file.
 */
public class FileUtil  {

	
	private static final String FILE_NAME = "items.txt";
	private static final String CARTS_NAME = "carts.txt";
	private static final String stock_NAME = "stock.txt";
	/**
	 *  This method used to write the entire list of items to file.
	 * @param items - this is ArrayList contains all newly created items.
	 * @throws IOException - exception class.
	 */
	public static void saveItems(List<Item> items) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(items);
		}
	}

	/**
	 * this method read all the items from the list.
	 * @return - return new arrayList or read objects from file.
	 * @throws IOException - exception class.
	 * @throws ClassNotFoundException - exception class.
	 */
	@SuppressWarnings("unchecked")
	public static List<Item> loadItems() throws IOException, ClassNotFoundException {
		File file = new File(FILE_NAME);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			return (List<Item>) ois.readObject();
		}
	}
	
	/**
	 * this method used to write all list of carts to the file .
	 * @param carts - this is arrayList contains all newly created carts .
	 * @throws IOException - exception class.
	 */

	public static void saveCarts(List<Cart> carts) throws IOException {
		// TODO Auto-generated method stub

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARTS_NAME))) {
			oos.writeObject(carts);
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * this method read all the carts from carts file.
	 * @return
	 * @throws IOException - exception class.
	 * @throws ClassNotFoundException - exception class.
	 */
	public static List<Cart> loadCarts() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(CARTS_NAME);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARTS_NAME))) {
			return (List<Cart>) ois.readObject();
		}
	}
	
	/**
	 * this method used to write all stock list to the stock file.
	 * 
	 * @param stock - this is the arrayList contains all newly created stock.
	 * @throws IOException - exception class.
	 */
	
	public static void saveStock(List<Stock> stock) throws IOException {
		// TODO Auto-generated method stub

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(stock_NAME))) {
			oos.writeObject(stock);
		}
	}

	@SuppressWarnings("unchecked")
	/**
	 * this method read all stock from the stock file.
	 * @return
	 * @throws IOException - throws input output exception.
	 * @throws ClassNotFoundException - throws exception when class is not present with that name.
	 */
	
	public static List<Stock> loadStock() throws IOException, ClassNotFoundException {
		File file = new File(stock_NAME);
		if (!file.exists()) {
			return new ArrayList<>();
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(stock_NAME))) {
			return (List<Stock>) ois.readObject();
		}
	}	
}
