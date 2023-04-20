package com.yapletcoding.application;

import com.yapletcoding.model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class CateringFileScanner {
    private Map<String, Item> inventoryMap = new HashMap<>();
    private File cateringCSV;

    public CateringFileScanner(String fileName) {
        this.cateringCSV = new File(fileName);
    }

    public Map<String, Item> setInventory(){
        try {
            Scanner fileScan = new Scanner(cateringCSV);
            while(fileScan.hasNextLine()){
                String aLine = fileScan.nextLine();
                String[] itemLineArray = aLine.split("\\,");
                if(itemLineArray[3].equalsIgnoreCase("Candy")) {
                    Item newItem = new Candy(itemLineArray[0], itemLineArray[1], new BigDecimal(itemLineArray[2]), itemLineArray[3]);
                    inventoryMap.put(itemLineArray[0], newItem);
                }else if(itemLineArray[3].equalsIgnoreCase("Drink")) {
                    Item newItem = new Drink(itemLineArray[0], itemLineArray[1], new BigDecimal(itemLineArray[2]), itemLineArray[3]);
                    inventoryMap.put(itemLineArray[0], newItem);
                }else if(itemLineArray[3].equalsIgnoreCase("Gum")) {
                    Item newItem = new Gum(itemLineArray[0], itemLineArray[1], new BigDecimal(itemLineArray[2]), itemLineArray[3]);
                    inventoryMap.put(itemLineArray[0], newItem);
                }else if(itemLineArray[3].equalsIgnoreCase("Munchy")) {
                    Item newItem = new Munchy(itemLineArray[0], itemLineArray[1], new BigDecimal(itemLineArray[2]), itemLineArray[3]);
                    inventoryMap.put(itemLineArray[0], newItem);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inventoryMap;
    }

    public void displayInventory(){
        List<String> itemToString = new ArrayList<>();
        for(Map.Entry<String, Item> each: inventoryMap.entrySet()){
            itemToString.add(each.getValue().toString());
        }
        Collections.sort(itemToString);
        for(String each: itemToString){
            System.out.println(each);
        }
    }

    public String[] makeArrayForReport(){
        String[] itemNameArray = new String[inventoryMap.size()];
        List<String> itemNameList= new ArrayList<>();
        for(Map.Entry<String,Item> each: inventoryMap.entrySet()){
            itemNameList.add(each.getValue().getItemName());
        }
        Collections.sort(itemNameList);
        return itemNameList.toArray(itemNameArray);
    }



}
