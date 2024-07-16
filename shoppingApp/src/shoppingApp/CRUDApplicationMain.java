package shoppingApp;

import java.util.List;
import java.io.IOException;
import java.util.Scanner;

import Source.Bill;
import Source.Cart;
import Source.Item;
import Source.Stock;
import util.FileUtil;
import util.ListUtil;

/**
 * The class CRUDApplicationMain performs the control action, it acts as a
 * central part of application which provides the menue to perform all the
 * operations and will be used to write and load data.
 */

public class CRUDApplicationMain {
	/**
	 * This is the shopping application start or entry point
	 * 
	 * @param args - array of arguments
	 */
	public static void main(String[] args) {
		try {
			List<Item> items = FileUtil.loadItems();
			List<Cart> carts = FileUtil.loadCarts();
			List<Stock> stocks = FileUtil.loadStock();
			Scanner scanner = new Scanner(System.in);
			boolean running = true;

			while (running) {
				System.out.println("Choose an operation: create, read, update, delete, addStock, readStock, sell, allcarts, exit");
				String operation = scanner.nextLine();

				switch (operation.toLowerCase()) {
				case "create":
					createItem(scanner, items);
					break;
				case "read":
					readItems(items);
					break;
				case "update":
					updateItem(scanner, items);
					break;
				case "delete":
					deleteItem(scanner, items, stocks);
					break;
				case "addStock":
					addStock(scanner, stocks, items);
					break;
				case "readstock":
					readStock(stocks, items);
					break;
				case "sell":
					sellItem(scanner, items, stocks, carts);
					break;
				case "allcarts":
					double total = ListUtil.showAllCarts(carts);
					System.out.println("\n ==================== Shop Sell: "+total+"=======================");
					break;
				case "exit":
					running = false;
					break;
				default:
					System.out.println("Invalid operation");
				}
				FileUtil.saveItems(items);
				FileUtil.saveStock(stocks);
				FileUtil.saveCarts(carts);
			}
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
			
		}
	}
	
	/**
	 * This method read the current stock.
	 * @param stocks - list used to hold the  stock item
	 * @param items - list of items
	 */
	private static void readStock(List<Stock> stocks, List<Item> items) {
		if (stocks.isEmpty()) {
			System.out.println("No stock found.");
		} else {
			for (Stock s : stocks) {
				s.printStock(items);
			}
		}
	}
	
	/**
	 * This method will update the current item stock.
	 * @param scanner - input stream
	 * @param stock - list used to hold the item stock in stock.txt
	 * @param items - list of items
	 */
	private static void addStock(Scanner scanner, List<Stock> stocks, List<Item> items) {
		System.out.println("Enter the Item Code: ");
		int code = Integer.parseInt(scanner.nextLine());
		if( !ListUtil.containsCode(code, items) ) // check given item code or entered item code is present in item list or not.
		{
			System.out.println("Invalid Item Code..!! Try another code");
			return;
		}
		System.out.println("Enter the Item Count: ");
		int itemcount = Integer.parseInt(scanner.nextLine());
		ListUtil.addOrUpdateStock(code, itemcount, stocks); // add or update stock according to the 
		System.out.println("Stock Added Sucessfully....!!!");		
	}

	/** This method sell the current item from stock
	 * @param scanner - default input stream
	 * @param items - used to pass list of items as a argument to the bill
	 * @param stocks - used to hold the item stock
	 * @param carts - hold the list of carts
	 */
	private static void sellItem(Scanner scanner, List<Item> items, List<Stock> stocks, List<Cart> carts) {
		
		Cart cart = new Cart();   // object of cart class
		String choice;
		int code, count;
		do {
			System.out.println("Enter item code:");
			code = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter item count:");
			count = Integer.parseInt(scanner.nextLine());
			if(ListUtil.isInStock(code, count, stocks))  // check given item code present in stock whose actual count is greater than entered count
				cart.addItem(new Bill(ListUtil.getItemByCode(items, code), count));  //  call addItem method from Cart class, Bill is passed as a argument which contains items, code, and count. 
			else 
				System.out.println("Item Not in Stock");
			
			System.out.println("Press yes to continue and no to stop:");
			choice = scanner.nextLine();
		} while (choice.equals("yes"));
		
		// 1 cart is a collection of individual bill
		do
		{
			System.out.println("The Current cart Bill: Rs."+cart.getTotalBill());  // gives the total by adding price*count of each bill 
			System.out.println("Press yes to pay and remove to remove items from cart:");
			choice = scanner.nextLine();
			if(choice.equals("remove"))
			{
				ListUtil.showCart(cart); // display all items from cart
				
				System.out.println("Enter item code:");
				code = Integer.parseInt(scanner.nextLine());
				System.out.println("how many items:");
				count = Integer.parseInt(scanner.nextLine());
				cart.remove(code,count);
			}
		}while(!choice.equals("yes"));
		carts.add(cart);  // add current cart into cart list.   
		ListUtil.UpdateStock(cart, stocks); // decrease stock. 
	}

	/**
	 * This is the method used to create the new Items
	 * 
	 * @param scanner - default input stream
	 * @param items   - ArrayList used to store newly created items, which will be
	 *                written in the items.txt at ast
	 */
	private static void createItem(Scanner scanner, List<Item> items) {

		System.out.println("Enter item id:");
		int id = Integer.parseInt(scanner.nextLine());

		System.out.println("Enter item name:");
		String name = scanner.nextLine();

		System.out.println("Enter item price:");
		double price = Double.parseDouble(scanner.nextLine());

		items.add(new Item(id, name, price));
		System.out.println("Item created.");
	}

	/**
	 * this will reads all the items from the file
	 * 
	 * @param items : list of Items
	 */
	private static void readItems(List<Item> items) {
		if (items.isEmpty()) {
			System.out.println("No items found.");
		} else {
			for (Item item : items) {
				System.out.println(item);
			}
		}
	}

	/**
	 * This method used to update the name and price of an individual Item
	 * 
	 * @param scanner - input stream
	 * @param items   - list of Items
	 */
	private static void updateItem(Scanner scanner, List<Item> items) {
		System.out.println("Enter item id to update:");
		int id = Integer.parseInt(scanner.nextLine());
		for (Item item : items) {
			if (item.getId() == id) {
				System.out.println("Enter new item name:");
				String newName = scanner.nextLine();
				System.out.println("Enter new item price:");
				double newprice = Double.parseDouble(scanner.nextLine());
				item.setName(newName);
				item.setPrice(newprice);
				System.out.println("Item updated.");
				return;
			}
		}
		System.out.println("Item not found.");
	}

	/**
	 * Used to delete the item from the item list with the help of item code.
	 * 
	 * @param scanner - input stream
	 * @param items   - List of items
	 */
	private static void deleteItem(Scanner scanner, List<Item> items, List<Stock> stock) {
		System.out.println("Enter item id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		int flg=0;
		for(int i=0 ; i<items.size() ; i++)
		{
			if(items.get(i).getId() == id)
			{
				items.remove(i);
//				stock.remove(i);
				System.out.println("Item deleted.");
				
				flg=1;
			}
		}
		if(flg==0)
			System.out.println("Invalid id.");
	}
}
