package util;
/**
 * util package.
 */
import java.util.List;

import Source.Bill;
import Source.Cart;
import Source.Item;
import Source.Stock;
/**
 *  This class defines several different methods used to process the different lists
 */
public class ListUtil {
	/**
	 * search for the current code in the list of items.
	 * @param code - This is item code to be searched.
	 * @param items - this is list where you have to search the item.
	 * @return - return true if entered code is present in Item List.
	 */
	
	
	public static boolean containsCode(int code, List<Item> items) {
		for(Item i : items) {
			if(i.getId()==code)
				return true;
		}
		return false;
	}
	
	/**
	 * this method add or remove the item from the stock.
	 * @param code - this is the item code to be added or removed.
	 * @param itemcount - this is the current item count.
	 * @param stocks - this is the list where item count would be added or removed
	 */

	public static void addOrUpdateStock(int code, int itemcount, List<Stock> stocks) {

		// if stock list is empty
		if(stocks.isEmpty()) {
			stocks.add(new Stock(code, itemcount));
			return;
		}
		
		// if stock having entry, the add/increase stock of item having same code
		boolean flg = false;
		for(Stock s : stocks) {
			if(s.getCode()==code) {
				s.updateStock(itemcount);
				flg=true;
			}
		}
		
		// if stock don't have entry, adding the stock of code <code> first time
		if(!flg) {
			stocks.add(new Stock(code, itemcount));
		}
			
	}
	
	/**
	 * write the item object for entered item code.
	 * @param items - this is the item list in which code to be searched.
	 * @param code - current item code.
	 * @return - return the item object for given item code.
	 */
	
	public static Item getItemByCode(List<Item> items, int code) {
		
		for (Item i : items) {
			if (i.getId() == code)
				return i;
		}
		return null;
	}

	/**
	 * this method check the give item code is present into the stock or not.
	 * @param code - given item code.
	 * @param count - given item count.
	 * @param stocks - this is the stockList where we check item code is present or not.
	 * @return - return true if entered code is present in stock whose count is greater than entered count. 
	 */
	public static boolean isInStock(int code, int count, List<Stock> stocks) {

		for(Stock s : stocks) {
			if(s.getCode()==code && s.getCountinstock()>=count) {
				return true;				
			}
		}
		return false;
	}

	/**
	 * this method show all carts
	 * @param cart - this is the cart which cotain all cart details 
	 */
	public static void showCart(Cart cart) {
		System.out.println("\n -----------------------------------------------------");
		cart.showBills();
	}
	
	/**
	 * this method update the  stock according to the current details.
	 * @param cart - object of cart class
	 * @param stocks - this is the stock list of which we update the details
	 */

	public static void UpdateStock(Cart cart, List<Stock> stocks) {
		
		List<Bill> bill = cart.getBilList();
		for(Bill b : bill) {
			decreaseStock(b.getId(), b.getCount(), stocks);
		}
		
	}

	/**
	 * this method help to reduce the count for given item code.
	 * @param id - gives the given id.
	 * @param count - gives item count for given id. 
	 * @param stocks - this is the stock list from which we decrease the stock.
	 */
	private static void decreaseStock(int id, int count, List<Stock> stocks) {

		for (Stock s : stocks) {
			if(s.getCode() == id) {
				s.updateStock(-count);
			}
		}
	}

	/**
	 * this method display all carts.
	 * @param carts - gives cart list.
	 * @return - return total shopsell.
	 */
	public static double showAllCarts(List<Cart> carts) {
		double shopsell = 0.0;
		for (int i = 0; i < carts.size(); i++) {
			System.out.print("\n------- Cart:" + (i + 1) + " --------\n");
			carts.get(i).showBills();
			System.out.print("\n------- Cart Total: " +carts.get(i).getTotalBill());
			shopsell+=carts.get(i).getTotalBill();
		}
		return shopsell;
	}
}
