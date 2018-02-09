package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation  {

    public static void print(String s) {
        System.out.println(s);
    }

    //Declaring variables
    private ArrayList<Item> loadArray = new ArrayList<>();
    private ArrayList<U1> loadedU1Array = new ArrayList<>();
    private ArrayList<U2> loadedU2Array = new ArrayList<>();

    private int cost = 0;

    public Simulation() throws Exception{}

    /**
     * This method generates an ArrayList of type Item from the txt file
     *
     * NOTE: The functionality of this method, at this point, is based on the following assumption:
     *      Each item in the txt file is in a new line, AND
     *      The format is name=weight and it splits it using the "=" delimiter, and the weights are in ton
     *
     * @param s this is the name of the file (e.g phase-1.txt)
     * @return the ArrayList of Items from that file
     * @throws Exception (File not Found)
     */
    public ArrayList<Item> loadItems (String s) throws Exception {

        File file = new File (s);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String entry = scanner.nextLine();
            String inputArray[] = entry.split("=");
            Item item = new Item(inputArray[0], Integer.parseInt(inputArray[1]));
            loadArray.add(item);
        }
        return loadArray;
    }

    public ArrayList<U1> loadU1 (ArrayList<Item> inputArray) {
        U1 u1 = new U1();
        while (inputArray.size() > 0) {
            int size = inputArray.size();
            for (int i=size; i>0 ; i--) {
                Item item = inputArray.get(i-1);
                if (u1.canCarry(item)) {
                    u1.carry(item);
                    inputArray.remove(i-1);
                } //if
            } //for
            loadedU1Array.add(u1);
            u1 = new U1();
        } //while
        return loadedU1Array;
    } //loadU1

    //Identical to the method for U1, but for U2
    public ArrayList<U2> loadU2 (ArrayList<Item> inputArray) {
        U2 u2 = new U2();
        while (inputArray.size() > 0) {
            int size = inputArray.size();
            for (int i=size; i>0 ; i--) {
                Item item = inputArray.get(i-1);
                if (u2.canCarry(item)) {
                    u2.carry(item);
                    inputArray.remove(i-1);
                } //if
            } //for
            loadedU2Array.add(u2);
            u2 = new U2();
        } //while
        return loadedU2Array;
    } //loadU1

}
