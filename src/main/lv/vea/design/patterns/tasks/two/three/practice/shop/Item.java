package lv.vea.design.patterns.tasks.two.three.practice.shop;

import java.math.BigDecimal;

public class Item {

    private int quantity;
    private String code;
    private BigDecimal cost;

    public Item(int quantity, String code, BigDecimal cost) {
        this.quantity = quantity;
        this.code = code;
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
