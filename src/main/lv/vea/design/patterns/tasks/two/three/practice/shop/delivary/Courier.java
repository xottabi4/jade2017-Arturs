package lv.vea.design.patterns.tasks.two.three.practice.shop.delivary;

import lv.vea.design.patterns.tasks.two.three.practice.shop.Customer;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by m7_anohin_a on 12/1/2017.
 */
public abstract class Courier {

    protected String name;

    abstract public BigDecimal determineDeliveryCosts(List<Item> item, Customer customer);

    abstract public String getOrderStatus(long orderId);

    abstract public void orderCourierDelivery(List<Item> item, Customer customer);

    public String getName() {
        return name;
    }
}
