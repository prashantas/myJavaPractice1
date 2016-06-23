package RiaPack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectSortingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order o1 = new Order(100,1000,"Sony");
		Order o2 = new Order(101,2000,"Hitachi");
		Order o3 = new Order(102,3000,"Philips");
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(o2);
		orders.add(o1);
		orders.add(o3);
		
		System.out.println("unsorted collection:" + orders);
		
		Collections.sort(orders);
		System.out.println("List of Order object sorted in natural order : " + orders);
		
		Collections.sort(orders, Collections.reverseOrder());
		
		//Sorting object using Comparator in Java
		Collections.sort(orders, new Order.OrderByAmount());
		System.out.println("List of Order object sorted using Comparator - amount : " + orders);
		
		Collections.sort(orders, new Order.OrderByCustomer());
		System.out.println("Collection of Orders sorted using Comparator - by customer : " + orders);
	}

}

class Order implements Comparable<Order>
{
	private int orderId;
	private int amount;
	private String customer;
	/*
     * Comparator implementation to Sort Order object based on Amount
     */
	public static class OrderByAmount implements Comparator<Order>
	{
		public int compare(Order o1, Order o2)
		{
			return o1.amount > o2.amount ? 1 : ( o1.amount < o2.amount ? -1 : 0 );
		}
	}
	/*
     * Anohter implementation or Comparator interface to sort list of Order object
     * based upon customer name.
     */
	public static class OrderByCustomer implements Comparator<Order>
	{
		public int compare(Order o1, Order o2)
		{
			return o1.customer.compareTo(o2.customer);
		}
	}
	
	public Order(int oi, int am, String cus)
	{
		this.orderId = oi;
		this.amount = am;
		this.customer = cus;
	}
	
	public int getAmount() {return amount; }
    public void setAmount(int amount) {this.amount = amount;}

    public String getCustomer() {return customer;}
    public void setCustomer(String customer) {this.customer = customer;}

    public int getOrderId() {return orderId;}
    public void setOrderId(int orderId) {this.orderId = orderId;}
    
    public int compareTo(Order o)
    {
    	return this.orderId > o.orderId ? 1 : ( this.orderId < o.orderId ? -1 : 0 ) ;
    }
    /*public String toString(){
        return String.valueOf(orderId);
    }*/

	@Override
	public String toString() {
		return "Order {orderId=" + orderId + ", amount=" + amount
				+ ", customer=" + customer + "}";
	}
}