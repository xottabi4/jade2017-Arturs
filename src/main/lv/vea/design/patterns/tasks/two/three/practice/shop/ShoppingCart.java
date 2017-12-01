package lv.vea.design.patterns.tasks.two.three.practice.shop;

import lv.vea.design.patterns.tasks.two.three.practice.shop.delivary.Courier;
import lv.vea.design.patterns.tasks.two.three.practice.shop.delivary.CourierFactory;
import lv.vea.design.patterns.tasks.two.three.practice.shop.order.Order;
import lv.vea.design.patterns.tasks.two.three.practice.shop.order.OrderService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ShoppingCart {

    private OrderService orderService;

    private Customer customer;

    private Courier courier;


    private List<Item> itemsInCart = new LinkedList<>();

    public ShoppingCart(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Calculate total costs of items in the ShoppingCart - including taxes
     *
     * @param customer - customer in question
     * @return total costs
     */
    public double calculateTotal(Customer customer) {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itemsInCart) {
            total = total.add(item.getCost()
                    .multiply(new BigDecimal(item.getQuantity())));
        }

//
//        double tax;
//        if (customer.getStateCode() == "DE")
//            tax = total * .08d;
//        else if (customer.getStateCode() == "FR")
//            tax = total * .09d;
//        else
//            tax = .03d;
//
//        total = total + tax;
//        return total;
        return 0;
    }

    public void removeItem(Item item) {
        itemsInCart.remove(item);
    }

    public void addItem(Item item) {
        itemsInCart.add(item);
    }

    public void setCourier(String courier) {
        this.courier = CourierFactory.getCourier(courier);
    }

    /**
     * On checkout, Pay method is called providing the method of paying (e.g. PayPal, MasterCard). Method uses corresponding services
     * to do money transaction from Customer's account to Companies account.
     *
     * @param customer - Customer in question
     * @param method   - Paying method string
     */
    public void pay(Customer customer, String method) {

        double amount = calculateTotal(customer);

        if (method.equalsIgnoreCase("PayPal")) {
            PayPalAccount acc = new PayPalAccount(customer);
            String account = PayPalAccount.findAccount(new Customer());
            acc.pay(amount, account);
        } // TODO Add MasterCard and Visa services in the future

//        create new order
        Order order = new Order(customer, itemsInCart, courier);

//        save order to DB using orderService
        orderService.saveOrder(order);
    }


    public Map<String, BigDecimal> viewDeliveryOptions() {
        List<Courier> availableCouriers = CourierFactory.getAllAvailableCouriers();

//        Map<String, BigDecimal> asd = availableCouriers.stream()
//                .collect(Collectors.toMap(Courier::getName, new BigDecimal("")));

        Map<String, BigDecimal> map = new HashMap<>();

        for (Courier courier : availableCouriers) {
            map.put(courier.getName(), courier.determineDeliveryCosts(itemsInCart, customer));
        }
        return map;
    }
}
