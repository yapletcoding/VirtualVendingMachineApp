package com.yapletcoding.application;

import java.math.BigDecimal;

public class MoneyMachine {
    private BigDecimal balance;

    public MoneyMachine() {
        this.balance = new BigDecimal("0.00");
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(BigDecimal addAmount) {
        this.balance = this.balance.add(addAmount);
    }

    public void subtractBalance(BigDecimal cost) {
        this.balance = this.balance.subtract(cost);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void dispenseChange(){
        int dollarCount = 0;
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        while(balance.compareTo(new BigDecimal("1")) >= 0){
            subtractBalance(new BigDecimal("1"));
            dollarCount++;
        }
        while(balance.compareTo(new BigDecimal("0.25")) >= 0){
            subtractBalance(new BigDecimal("0.25"));
            quarterCount++;
        }
        while(balance.compareTo(new BigDecimal(".1")) >= 0){
            subtractBalance(new BigDecimal(".1"));
            dimeCount++;
        }
        while(balance.compareTo(new BigDecimal(".05")) >= 0){
            subtractBalance(new BigDecimal(".05"));
            nickelCount++;
        }
        System.out.println("\uD83E\uDD11 \uD83E\uDD11 \uD83E\uDD11 \uD83E\uDD11");
        System.out.println("Change Dispensed: "+dollarCount+" dollar"+(dollarCount >1?"s, ":", ")
                + quarterCount+" quarter"+(quarterCount >1?"s, ":", ")
                + dimeCount+" dime"+(dimeCount >1?"s and ":" and ")
                + nickelCount+ " nickel"+(nickelCount >1?"s.":"."));
        System.out.println("\uD83D\uDCB0 \uD83D\uDCB2 \uD83D\uDCB0 \uD83D\uDCB2");
        System.out.println("Clink!! Clink!! Clink!! Clink!!");
        System.out.println("\uD83D\uDCB8 \uD83D\uDCB8 \uD83D\uDCB8 \uD83D\uDCB8");
        setBalance(new BigDecimal("0.00"));
    }
}
