package com.yapletcoding.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 *
 * Dependencies: None
 */
public class UserInput {
    private Scanner scanner = new Scanner(System.in);
    UserOutput userOutput= new UserOutput();

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
//        System.out.println();

        System.out.println("1) Display Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

//        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("1")) {
            return "display";
        }
        else if (option.equals("2")) {
            return "purchase";
        }
        else if (option.equals("3")) {
            return "exit";
        }
        else {
            return "";
        }
    }

    public String getPurchaseScreenOption(BigDecimal balance) {
        System.out.println("What would you like to do?");
//        System.out.println();

        System.out.println("1) Feed Money");
        System.out.println("2) Select Item");
        System.out.println("3) Finish Transaction");
        System.out.println();

        userOutput.currentBalanceIs(balance);

//        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("1")) {
            return "feed";
        }
        else if (option.equals("2")) {
            return "select";
        }
        else if (option.equals("3")) {
            return "finish";
        }
        else {
            return "";
        }
    }

    public String getFeedMoneyInput(BigDecimal balance) {
        System.out.println("What would you like to do?");
//        System.out.println();

        System.out.println("1) Insert $1 bill");
        System.out.println("5) Insert $5 bill");
        System.out.println("10) Insert $10 bill");
        System.out.println("20) Insert $20 bill");
        System.out.println("0) Go back.");

        System.out.println();
        userOutput.currentBalanceIs(balance);
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();
        if (option.equals("1")) {
            return "1";
        }
        else if (option.equals("5")) {
            return "5";
        }
        else if (option.equals("10")) {
            return "10";
        }
        else if (option.equals("20")) {
            return "20";
        }
        else if (option.equals("0")) {
            return "0";
        }
        else {
            return "";
        }
    }

    public String getSelectItem(){
        System.out.print("Please select an option: ");
        return scanner.nextLine().trim().toUpperCase();
    }

}

