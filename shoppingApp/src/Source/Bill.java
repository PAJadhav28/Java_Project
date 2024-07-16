package Source;

import java.io.Serializable;
import java.util.List;

/** 
 * This class used to calculate item bill
 * @author COMnet
 *
 */
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int count;
	private double totalpricefornitems;
	private Item item;
	
	public Bill(Item item, int count) { 
		this.item = item;
		this.id = item.getId();
		this.count = count;
		this.totalpricefornitems=item.getPrice()*this.count;
	}

	public int getId() {
		return id;
	}
	
	public int getCount() {
		return count;
	}

	public double getIndividuaTotal() {
		return totalpricefornitems;
	}
	
	/**
	 * Display item details and bill
	 * totalpricefornitems - calculate item wise total with the help of item count and item price
	 */

	public void showBilledItem()
	{
		this.totalpricefornitems=item.getPrice()*this.count;
		System.out.println("ID: "+id+"\t Name: "+item.getName()+"\t Price: "+item.getPrice()+"\t count: "+count+"\t Total Items Price: "+totalpricefornitems);
	}

	/**
	 * This method used to set the count and calculate the total price according to that count
	 * @param count - store current item count
	 */
	public void setCount(int count) {
		this.count -= count;
		this.totalpricefornitems=item.getPrice()*this.count;
	}
}


