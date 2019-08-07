package com.company;

import java.util.Comparator;

public class Item {
    public String name;
    public int value;
    public int weight;

    public Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String str() {
        return name + " [value = " + value + ", weight = " + weight + "]";
    }

    public int getRatio(){
        return value / weight;
    }

    public String getName() {
        return name;
    }
}
