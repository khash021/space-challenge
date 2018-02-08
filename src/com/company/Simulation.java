package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //Declaring variables
    private ArrayList<Item> loadArray = new ArrayList<>();
    private ArrayList<U1> loadedU1Array = new ArrayList<>();
    private ArrayList<U2> loadedU2Array = new ArrayList<>();

    private int cost = 0;

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

    public ArrayList<U1> loadU1 (ArrayList inputArray) {

    }

    public ArrayList<U1> loadU1 (ArrayList inputArray) {

    }

    public int runSimulation (ArrayList phase1, ArrayList phase2) {

    }

}
