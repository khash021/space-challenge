package com.company;

public class Item {

    String name;
    int weight;

    //Default constructor
    public Item(){}

    //Constructor with two input args
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName (Item item){
        return item.name;
    }

    public int getWeight(Item item){
        return item.weight;
    }

}


