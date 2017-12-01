package lv.vea.design.patterns.tasks.two.three.practice.order;

import lv.vea.design.patterns.tasks.two.three.practice.shop.Customer;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Item;
import lv.vea.design.patterns.tasks.two.three.practice.delivary.Courier;

import java.util.List;

/**
 * Created by m7_anohin_a on 12/1/2017.
 */
public class Order {

    private long id;

    private long courierId;

    private OrderState orderState;

    private Customer customer;

    private List<Item> items;

    private Courier courier;

    public Order(Customer customer, List<Item> items, Courier courier) {
        this.customer = customer;
        this.items = items;
        this.courier = courier;
    }
}
