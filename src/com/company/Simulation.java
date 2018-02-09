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

    private int totalCost = 0;

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
            for (int i=inputArray.size(); i>0 ; i--) {
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
            for (int i=inputArray.size(); i>0 ; i--) {
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


    public int runSimulation (String rocketType, int phase) throws Exception {
        //Determining the phase
        String fileName;
        switch (phase) {
            case 1:
                fileName = "phase-1.txt";
                break;
            case 2:
                fileName = "phase-2.txt";
                break;
            default:
                print("Invalid input (possible mis-spelling)");
                return -1;
        } //switch

        ArrayList<Item> itemList = this.loadItems(fileName);

        //Determining the ship type for simulation
        switch (rocketType) {
            case "u1": case "U1":
            U1 u1 = new U1();
            ArrayList<U1> U1Array = this.loadU1(itemList);

            while (U1Array.size() > 0) {
                for (int i = U1Array.size(); i>0; i--) {
                    u1 = U1Array.get(i - 1);
                    int counter = 1;
                    while (!(u1.land(u1.currentCargo) && u1.launch(u1.currentCargo))) {
                        counter++;
                    } //while
                    totalCost += u1.cost * counter;
                    U1Array.remove(i-1);
                } //if
            } //while
            return totalCost;

            case "u2": case "U2":
            U2 u2 = new U2();
            ArrayList<U2> U2Array = this.loadU2(itemList);

            while (U2Array.size() > 0) {
                for (int i = U2Array.size(); i>0; i--) {
                    u2 = U2Array.get(i - 1);
                    int counter = 1;
                    while (!(u2.land(u2.currentCargo) && u2.launch(u2.currentCargo))) {
                        counter++;
                    } //while
                    totalCost += u2.cost * counter;
                    U2Array.remove(i-1);
                } //if
            } //while
            return totalCost;

            default:
            print("Invalid input (possible mis-spelling)");
            return -1; //We can use -1 in the method call in Main to handle all invalid inputs since cost can never be negative
        } //switch

    } //runSimulation

} //main
