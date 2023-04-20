package com.yapletcoding.application;

import com.yapletcoding.model.Item;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class SalesReportWriter {
    File reportFile;
    String[] itemNames;
    int[] fullSaleCount;
    int[] discountSaleCount;

    public SalesReportWriter(String fileName, Map<String, Item> map, String[] itemNames) {
        this.reportFile = new File(fileName);
        this.itemNames = itemNames;
        this.fullSaleCount = new int[map.size()];
        this.discountSaleCount = new int[map.size()];
        for(int i=0; i <itemNames.length; i++){
            fullSaleCount[i] = 0;
            discountSaleCount[i] = 0;
        }
    }

    public void report(String itemName ,boolean BOGODO){
        for(int i=0; i <itemNames.length; i++){
            if(itemName.equals(itemNames[i])){
                if(BOGODO){
                    discountSaleCount[i]= discountSaleCount[i]+1;
                }if(!BOGODO){
                    fullSaleCount[i]= fullSaleCount[i]+1;
                }
            }
        }
        try(PrintWriter writer = new PrintWriter(reportFile.getAbsoluteFile())){
            writer.println("Vending Sales Report");
            for(int i=0; i <itemNames.length; i++){
                writer.println(String.format("%-20s",itemNames[i])+ "|"+ fullSaleCount[i]+ "|" + discountSaleCount[i]);
            }
        }catch(IOException e){
            System.out.println("File not found!");
        }
    }



    //    public boolean firstLine = true;
//
//    public void initiateSalesReport(Map<String,Item> slotItemMap){
//        try(PrintWriter writer = new PrintWriter(reportFile.getAbsoluteFile())){
////            writer.println("Thwin's Vending Sales Report");
//            for(Map.Entry<String,Item> each: slotItemMap.entrySet()){
//                writer.println(String.format("%-20s",each.getValue().getItemName())  + "|0|0");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void report(String itemName,boolean BOGODO){
//        try(Scanner scanner = new Scanner(reportFile.getAbsoluteFile());
//        PrintWriter printWriter = new PrintWriter(new FileOutputStream(reportFile.getAbsoluteFile(),true))){
////            scanner.nextLine();
//            while (scanner.hasNextLine()) {
////                if (firstLine) {
////                    firstLine = false;
////                    System.out.println(scanner.nextLine());
////                } else if(!firstLine) {
//                    String line = scanner.nextLine();
//                    String[] parts = line.split("[|]");
//                    String product = parts[0].trim();
//                    Integer fullCount = Integer.parseInt(parts[1]);
//                    Integer discountCount = Integer.parseInt(parts[2]);
//                    if (product.equals(itemName)) {
//                        if (BOGODO) {
//                            printWriter.println(String.format("%-20s", product) + "|" + fullCount + "|" + (discountCount + 1));
//                        } else {
//                            printWriter.println(String.format("%-20s", product) + "|" + (fullCount + 1) + "|" + discountCount);
//                        }
//                    }
////                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
