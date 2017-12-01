package lv.vea.design.patterns.tasks.two.three.practice;

import lv.vea.design.patterns.tasks.two.three.practice.shop.order.OrderService;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Customer;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Item;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Shop;
import lv.vea.design.patterns.tasks.two.three.practice.shop.ShoppingCart;

import java.math.BigDecimal;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Shop shop = new Shop();
        shop.addItem(new Item(2, "bla", new BigDecimal(9.4)));

        System.out.println(shop.getAllItems(new Customer()).toString());


        //when customer found what he wan't to buy
        ShoppingCart shoppingCart = new ShoppingCart(new OrderService());

        Item item = shop.findItemByCode("bla");
        shoppingCart.addItem(item);

        Map<String, BigDecimal> asd=shoppingCart.viewDeliveryOptions();
        //Customer sets courier that he want's to use
        shoppingCart.setCourier("DPD");




//		Design Delivery service.
// 1. Add delivery service to shop design.
// 2. Delivery service uses third party logistic companies API to access delivery costs.
// 3. Customer should be notified of order delivery status changes.


    }

}
