package com.yapletcoding.model;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String itemSlot, String itemName, BigDecimal price, String itemType){
        super(itemSlot,itemName,price,itemType);
    }

    public String makeNoise(){
        return "Drinky, Drinky, Slurp Slurp!  \n\uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29";
    }
}
