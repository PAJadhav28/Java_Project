package Source;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class used to display all selled item details, item wise total and shop sell
 * @author COMnet
 *
 */

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List <Bill> bill = new ArrayList<Bill>(); 
	
	/**
	 * this method add bill to current list bill.
	 * @param bill - object of list type Bill.
	 */
	public void addItem(Bill bill) {
		
		this.bill.add(bill);
	}
	
	
	public void showBills() {
		for(int i=0;i<bill.size();i++)
		{
			bill.get(i).showBilledItem();
		}
	}
	
	
	/**
	 *  add all item Individual total into tot
	 * @return - return total
	 */
	public double getTotalBill() {
		double total = 0.0;
		for(Bill b : bill) {
			total = total + b.getIndividuaTotal();
		}
		return total;
	}

	/**
	 * this method remove the count entered for given item code
	 * @param code - item code
	 * @param count - item count
	 */
	public void remove(int code, int count) {
		for(int i=0 ; i<bill.size();i++)
		{
			if(bill.get(i).getId()==code) {
				bill.get(i).setCount(count);
			}
		}
	}
	
	/**
	 *  
	 * @return - return the current bill object
	 */
	public List<Bill> getBilList() {
		return bill;
	}
}
