package lv.vea.design.patterns.tasks.two.three.practice;

import java.util.ArrayList;

public class ShoppingCart {
	
	ArrayList<Item> orderItems = new ArrayList<Item>();
	
	/**
	 * Calculate total costs of items in the ShoppingCart - including taxes
	 * @param customer - customer in question 
	 * @return total costs
	 */
    public double calculateTotal(Customer customer)
    {
    	double total = 0;
    	for (Item item : orderItems) {
			total += item.cost * item.quantity;
		}


        double tax;
        if (customer.stateCode == "DE")
            tax = total * .08d;
        else if (customer.stateCode == "FR")
            tax = total * .09d;
        else
            tax = .03d;

        total = total + tax;
        return total;
    }
    
    public void removeItem(Item item){
    	orderItems.remove(item);
    }
    
    public void addItem(Item item){
    	orderItems.add(item);
    }
    
    /**
     * On checkout, Pay method is called providing the method of paying (e.g. PayPal, MasterCard). Method uses corresponding services
     * to do money transaction from Customer's account to Companies account.  
     * @param customer - Customer in question
     * @param method - Paying method string
     */
    public void pay(Customer customer, String method){
    	
    	double amount = calculateTotal(customer);
    	
    	if(method.equalsIgnoreCase("PayPal")){
    		PayPalAccount acc = new PayPalAccount(customer);
    		String account = PayPalAccount.findAccount(new Customer());
    		acc.pay(amount, account);
    	} // TODO Add MasterCard and Visa services in the future
    	
    	
    }


}
