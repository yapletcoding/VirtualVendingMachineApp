package com.yapletcoding.model;

import java.math.BigDecimal;

public class Munchy extends Item{
    public Munchy(String slotName, String itemName, BigDecimal price, String itemType) {
        super(slotName, itemName, price, itemType);
    }

    public String makeNoise(){
        return "Munchy, Munchy, so Good!  \n\uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29";
    }
}
