package com.yapletcoding.model;

import java.math.BigDecimal;

public class Gum extends Item{
    public Gum(String slotName, String itemName, BigDecimal price, String itemType) {
        super(slotName, itemName, price, itemType);
    }

    public String makeNoise(){
        return "Chewy, Chewy, Lots O Bubbles!  \n\uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29 \uD83E\uDD29";
    }
}
