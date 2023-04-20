package com.yapletcoding.ui;

import com.yapletcoding.application.VendingMachine;

import java.math.BigDecimal;

public class UserOutput {
    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public void homeScreenTitle() {
        System.out.println();
        System.out.println("****************************************************");
        System.out.println("SPECIAL ANNOUNCEMENT: In honor of Thanksgiving, this");
        System.out.println("machine is running a BOGODO sale, buy one item, get ");
        System.out.println("one dollar off any second item.");
        System.out.println("****************************************************");
    }

    public void displayScreenTitle() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 INVENTORY DISPLAY");
        System.out.println("***************************************************");
        System.out.println("Slot    Item              Price    Type  Stock");
        System.out.println("===================================================");
    }

    public void purchaseScreenTitle() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      PURCHASE");
        System.out.println("***************************************************");
    }

    public void feedMoneyScreenTitle() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                     FEED MONEY");
        System.out.println("***************************************************");
        System.out.println("      WE ONLY ACCEPT $1, $5, $10, $20 bills        ");
        System.out.println("***************************************************");
    }

    public void selectItemScreenTitle(BigDecimal balance){
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                     SELECT ITEM ");
        System.out.println("***************************************************");
        System.out.println("      A1-A4       B1-B4       C1-C4       D1-D4       ");
        System.out.println("***************************************************");
        currentBalanceIs(balance);
    }

    public void currentBalanceIs(BigDecimal balance){
        System.out.println("Current balance is $" + balance + ".");
        if(VendingMachine.BOGODO()){
            System.out.println("BOGODO discount is available for the next item.");
        }
    }

    public void invalidInput(){
        System.out.println("!!!!!!!!!!!! Invalid Input! Try again !!!!!!!!!!!!!");
    }

    public void greetings(){
        System.out.println("\n" +
                "\n" +
                " ____________________________________________\n" +
                "|############################################|\n" +
                "|#|                           |##############|\n" +
                "|#|  =====  ..--''`  |~~``|   |##|````````|##|\n" +
                "|#|  |   |  \\     |  :    |   |##| Exact  |##|\n" +
                "|#|  |___|   /___ |  | ___|   |##| Change |##|\n" +
                "|#|  /=__\\  ./.__\\   |/,__\\   |##| Only   |##|\n" +
                "|#|  \\__//   \\__//    \\__//   |##|________|##|\n" +
                "|#|===========================|##############|\n" +
                "|#|```````````````````````````|##############|\n" +
                "|#| =.._      +++     //////  |##############|\n" +
                "|#| \\/  \\     | |     \\    \\  |#|`````````|##|\n" +
                "|#|  \\___\\    |_|     /___ /  |#| _______ |##|\n" +
                "|#|  / __\\\\  /|_|\\   // __\\   |#| |1|2|3| |##|\n" +
                "|#|  \\__//-  \\|_//   -\\__//   |#| |4|5|6| |##|\n" +
                "|#|===========================|#| |7|8|9| |##|\n" +
                "|#|```````````````````````````|#| ``````` |##|\n" +
                "|#| ..--    ______   .--._.   |#|[=======]|##|\n" +
                "|#| \\   \\   |    |   |    |   |#|  _   _  |##|\n" +
                "|#|  \\___\\  : ___:   | ___|   |#| ||| ( ) |##|\n" +
                "|#|  / __\\  |/ __\\   // __\\   |#| |||  `  |##|\n" +
                "|#|  \\__//   \\__//  /_\\__//   |#|  ~      |##|\n" +
                "|#|===========================|#|_________|##|\n" +
                "|#|```````````````````````````|##############|\n" +
                "|############################################|\n" +
                "|#|||||||||||||||||||||||||||||####```````###|\n" +
                "|#||||||||||||PUSH|||||||||||||####\\|||||/###|\n" +
                "|############################################|\n" +
                "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\///////////////////////\n" +
                " |____|Github|____________|YAPLETCODING|___|");
    }

    public void goodbye(){
        System.out.println(
                "████░██░██░░▄███▄░░██▄░██░██░▄██\n" +
                "░██░░██▄██░██▀░▀██░███▄██░████▀░\n" +
                "░██░░██▀██░███████░██▀███░████▄░\n" +
                "░██░░██░██░██░░░██░██░░██░██░▀██\n" +
                "\n" +
                "██▄░░▄██░░▄███▄░░██░░██░░\n" +
                "░▀████▀░░██▀░▀██░██░░██░░\n" +
                "░░░██░░░░██▄░▄██░██░░██░░\n" +
                "░░░██░░░░░▀███▀░░▀████▀░░\n" +
                "\n" +
                "██░░░██░████░████▄░██▄░░▄██░░\n" +
                "██▄░▄██░██▄░░██░██░░▀████▀░░░\n" +
                "░██▄██░░██▀░░████▀░░░░██░░░░░\n" +
                "░░███░░░████░██░██░░░░██░░░░░\n" +
                "\n" +
                "██▄░▄██░██░░██░░▄███▄░██░██\n" +
                "██▀█▀██░██░░██░██▀░▀▀░██▄██\n" +
                "██░░░██░██░░██░██▄░▄▄░██▀██\n" +
                "██░░░██░▀████▀░░▀███▀░██░██");
    }
}
