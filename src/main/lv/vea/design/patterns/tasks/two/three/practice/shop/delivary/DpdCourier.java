package lv.vea.design.patterns.tasks.two.three.practice.shop.delivary;

import lv.vea.design.patterns.tasks.two.three.practice.shop.Customer;
import lv.vea.design.patterns.tasks.two.three.practice.shop.Item;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by m7_anohin_a on 12/1/2017.
 */
public class DpdCourier extends Courier {

    private String name = "DPD";

    @Override
    public BigDecimal determineDeliveryCosts(List<Item> item, Customer customer) {
        return null;
    }

    @Override
    public String getOrderStatus(long orderId) {
        return null;
    }

    @Override
    public void orderCourierDelivery(List<Item> item, Customer customer) {

    }
}
