package com.yapletcoding.model;

import java.math.BigDecimal;

public class Candy extends Item{
    public Candy(String slotName, String itemName, BigDecimal price, String itemType) {
        super(slotName, itemName, price, itemType);
    }

    public String makeNoise(){
        return "Sugar, Sugar, so Sweet! \n\uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29";
    }
}
