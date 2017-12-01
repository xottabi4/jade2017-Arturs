package lv.vea.design.patterns.tasks.two.three.practice.delivary;

import lv.vea.design.patterns.tasks.two.three.practice.shop.Customer;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by m7_anohin_a on 12/1/2017.
 */
public interface Courier {

    BigDecimal determineDeliveryCosts(List<Item> item, Customer customer);

    String getOrderStatus(long orderId);

    void orderCourierDelivery(List<Item> item, Customer customer);

}
