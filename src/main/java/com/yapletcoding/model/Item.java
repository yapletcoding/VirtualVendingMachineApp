package com.yapletcoding.model;

import java.math.BigDecimal;

public abstract class Item {
    String slotName;
    String itemName;
    BigDecimal price;
    String itemType;
    int stock;

    public Item(String slotName, String itemName, BigDecimal price, String itemType) {
        this.slotName = slotName;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.stock = 6;
    }

    public String getItemName() {
        return itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract String makeNoise();

    public String toString(){
//        return slotName + "    " + itemName + "    " + price + "    " + itemType + "    " + stock;
        return (String.format("%s   %-20s $%-7s %-7s %-10s", slotName, itemName, price, itemType, stock));
    }
}
