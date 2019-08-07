package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Greedy{
    Item[] items;
    int capacity;
     public Greedy(Item[] items, int capacity){
         this.items = items;
         this.capacity = capacity;
    }

    public void GreedySolution(){
         System.out.println("\n \n Greedy solution for max items");
        double capacityUsed = 0;
        double value = 0;
        int i;
        Item[]sortedItems = sortWeight(items);

        List<Item> backpack = new ArrayList<>();
        for(i=0; i<sortedItems.length; i++){
            if(capacityUsed + sortedItems[i].weight <= capacity){
                capacityUsed+= sortedItems[i].weight;
                value += sortedItems[i].value;
                backpack.add(sortedItems[i]);
            }
        }

        for(i=0; i<backpack.size(); i++){
            System.out.println(backpack.get(i).str());
        }
        System.out.println("Total value: " + value);
        System.out.println("Total weight: " + capacityUsed);
        value =0;
        capacityUsed = 0;
        List<Item> backpackValue = new ArrayList<>();

        System.out.println("\n \n Greedy solution for max value");
        Item[]sortedItemsForMaxValue = sortValue(items);

        for(i=0; i<sortedItemsForMaxValue.length; i++){
            if(capacityUsed + sortedItemsForMaxValue[i].weight <= capacity){
                capacityUsed+= sortedItemsForMaxValue[i].weight;
                value += sortedItemsForMaxValue[i].value;
                backpackValue.add(sortedItemsForMaxValue[i]);
            }
        }
        for(i=0; i<backpackValue.size(); i++){
            System.out.println(backpackValue.get(i).str());
        }
        System.out.println("Total value: " + value);
        System.out.println("Total weight: " + capacityUsed);

    }
    public Item[] sortValue(Item[]items){
        boolean swapped;
        Item temp;
        for(int i=0; i<items.length; i++){
            swapped = false;
            for(int j=0; j< items.length - i -1; j++){
                if(items[j].value < items[j+1].value){
                    temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                    swapped = true;
                }
            }

            if(swapped == false){
                break;
            }
        }

        return items;
    }

    public Item[] sortWeight(Item[]items){
         boolean swapped;
         Item temp;
         for(int i=0; i<items.length; i++){
            swapped = false;
            for(int j=0; j< items.length - i -1; j++){
                if(items[j].getRatio() < items[j+1].getRatio()){
                    temp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = temp;
                    swapped = true;
                }
            }

            if(swapped == false){
                break;
            }
         }

         return items;

    }


}
