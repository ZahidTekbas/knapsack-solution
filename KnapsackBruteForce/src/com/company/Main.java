package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // read bag.txt
        BufferedReader br = null;
        List<List<String>> values = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("canta.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // get the values by line
        String line = br.readLine();
        while(line!=null){

            String temp[];
            temp=line.split(" ");
            List<String> tempList = new ArrayList<>();
            for(int i=0; i<temp.length; i++){
                tempList.add(temp[i]);
            }
            values.add(tempList);
            line = br.readLine();
            // add lines into a list of list of strings
        }
        Item[] items = new Item[values.size()];
        // then put them in item class in order to make calculations easy
        for(int i=0; i<values.size(); i++){
            items[i]= new Item(values.get(i).get(0),Integer.parseInt(values.get(i).get(1)),Integer.parseInt(values.get(i).get(2)));
        }
        Knapsack knapsack = new Knapsack(items, 50);
        knapsack.display();
        Solution solution = knapsack.solve();
        solution.display();
        Greedy greedy = new Greedy(items,50);
        greedy.GreedySolution();


    }
}
