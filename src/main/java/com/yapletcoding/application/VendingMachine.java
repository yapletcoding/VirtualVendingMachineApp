package com.yapletcoding.application;

import com.yapletcoding.model.Item;
import com.yapletcoding.ui.UserInput;
import com.yapletcoding.ui.UserOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    CateringFileScanner cateringFileScanner = new CateringFileScanner("catering.csv");
    MoneyMachine moneyMachine = new MoneyMachine();
    AuditWriter auditWriter = new AuditWriter("Audit.txt");
    SalesReportWriter salesReportWriter;
    private Map<String, Item> slotItemMap = new HashMap<>();
    public static int BOGODOcount = 1;
    int dumbCounter = 0;

    public void run() {
        userOutput.greetings();
        slotItemMap = cateringFileScanner.setInventory();
        String[] itemNamesArray= cateringFileScanner.makeArrayForReport();
        salesReportWriter= new SalesReportWriter("SalesReport.txt",slotItemMap, itemNamesArray);
        while (true) {
            userOutput.homeScreenTitle();
            String choice = userInput.getHomeScreenOption();
            if (choice.equals("display")) {
                userOutput.displayScreenTitle();
                cateringFileScanner.displayInventory();
            } else if (choice.equals("purchase")) {
                purchaseScreenOptions();
            } else if (choice.equals("exit")) {
                break;
            }
        }
    }

    public void purchaseScreenOptions() {
        while (true) {
            userOutput.purchaseScreenTitle();
            String choice = userInput.getPurchaseScreenOption(currentBalance());
            if (choice.equals("feed")) {
                feedMachine();
            } else if (choice.equals("select")) {
                cateringFileScanner.displayInventory();
                selectItem();
            } else if (choice.equals("finish")) {
                auditWriter.write("CHANGE GIVEN:",currentBalance(),new BigDecimal("0.00"));
                moneyMachine.dispenseChange();
                userOutput.goodbye();
                userOutput.greetings();
                break;
            }
        }
    }

    public void feedMachine() {
        while (true) {
            userOutput.feedMoneyScreenTitle();
            String choice = userInput.getFeedMoneyInput(currentBalance());
            BigDecimal oldBalance = currentBalance();
            if (choice.equals("")){
                userOutput.invalidInput();
            } else if (choice.equals("1")) {
                moneyMachine.addBalance(new BigDecimal("1.00"));
                auditWriter.write("MONEY FED:",oldBalance, currentBalance());
                break;
            } else if (choice.equals("5")) {
                moneyMachine.addBalance(new BigDecimal("5.00"));
                auditWriter.write("MONEY FED:",oldBalance, currentBalance());
                break;
            } else if (choice.equals("10")) {
                moneyMachine.addBalance(new BigDecimal("10.00"));
                auditWriter.write("MONEY FED:",oldBalance, currentBalance());
                break;
            } else if (choice.equals("20")) {
                moneyMachine.addBalance(new BigDecimal("20.00"));
                auditWriter.write("MONEY FED:",oldBalance, currentBalance());
                break;
            } else if (choice.equals("0")) {
                break;
            }
        }
    }

    public void selectItem(){
        while(true) {
            BigDecimal oldBalance = currentBalance();
            userOutput.selectItemScreenTitle(oldBalance);
            String choice = userInput.getSelectItem();
            Item selectedItem = slotItemMap.get(choice);
            if (slotItemMap.containsKey(choice) &&
                    selectedItem.getStock() > 0 &&
                    (currentBalance().compareTo(selectedItem.getPrice().subtract((BOGODO()? new BigDecimal("1") : new BigDecimal("0")))) >= 0)) {
                selectedItem.setStock(selectedItem.getStock() - 1);
                moneyMachine.subtractBalance(selectedItem.getPrice());
                if (BOGODO()){
                    moneyMachine.addBalance(new BigDecimal("1"));
                    salesReportWriter.report(selectedItem.getItemName(),true);
                }else {
                    salesReportWriter.report(selectedItem.getItemName(), false);
                }
                System.out.println("Vending 1 '"+ selectedItem.getItemName()+ (BOGODO()?"' with a BOGODO discount ":"' ") + "for you. :)");
                System.out.println(selectedItem.makeNoise());
                BOGODOcount++;
                auditWriter.write(String.format("%-17s",selectedItem.getItemName())+String.format("%2s",choice),oldBalance,moneyMachine.getBalance());
                userOutput.currentBalanceIs(currentBalance());
                break;
            } else if (!slotItemMap.containsKey(choice)) {
                System.out.println("\n        ❌   ❗  ⚠️❗   ❌       ");
                System.out.println("Invalid slot location. Try again.");
                dumbCounter++;
                if(dumbCounter >= 3){
                    System.out.println("        ❌   ❗  ⚠️❗   ❌       ");
                    System.out.println("YOU DUMB??? LEARN TO TYPE, NOOB!");
                }
                break;
            } else if (selectedItem.getStock() <= 0) {
                System.out.println("\n        ❌   ❗  ⚠️❗   ❌       ");
                System.out.println("Sorry. Item selected is out of stock");
                break;
            } else if (currentBalance().compareTo(selectedItem.getPrice())< 0){

                System.out.println("\n        ❌   ❗  ⚠️❗   ❌       ");
                System.out.println("Insufficient money for this item. Insert more CHA CHING!!!");
                break;
            }
        }
    }

    public BigDecimal currentBalance(){
        return moneyMachine.getBalance();
    }

    public static boolean BOGODO(){
        return BOGODOcount%2==0;
    }

}