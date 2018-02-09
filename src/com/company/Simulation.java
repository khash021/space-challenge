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
        //Checks to see if there is still any Items left in the input array to be loaded into U1 rockets
        U1 u1 = new U1();
        for (Item item : inputArray) {
            //First checks to see if item can be added, if not; it first add the U1 ship to the array, set the cargo
            //weight back to zero (start a new ship)
            if (!(u1.canCarry(item))) {
                loadedU1Array.add(u1);
                u1.currentCargo=0;
            }
            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                //if there is no more room left in u1, add loaded u1 rocket into the output array
                loadedU1Array.add(u1);
                u1.currentCargo=0;
            } //else
        } //for
        //Since on the last item, we might have missed the else method (it would not run it if there is still space
        //available on the ship) and we need to manually add the last ship which might not be full to the array
        loadedU1Array.add(u1);
        return loadedU1Array;
    } //loadU1

}
