package lv.vea.design.patterns.tasks.two.three.practice.shop;

/**
 * Third party API of PayPal service.
 * @author Janis
 *
 */

public class PayPalAccount {
	
	private Customer customer;

	private String accountNr;
	
	public PayPalAccount(Customer customer){
		this.customer = customer;
		accountNr = findAccount(customer);
	}
	
	/**
	 * Finds an account number for a particular Customer
	 * @param customer - Customer in question 
	 * @return
	 */
	public static String findAccount(Customer customer){
		// Do DB queries
		
		return "10102983621223";
	}
	
	/**
	 * Calls REST API making PayPal transaction
	 * @param amount - amount of money
	 * @param account - to whom to transfer the money
	 */
	public void pay(double amount, String account){
		// Call PayPal api
	}

}
