package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    /**
     * This method generates an ArrayList of type Item from the txt file
     * @param s this is the name of the file (e.g phase-1.txt)
     * @return the ArrayList of Items from that file
     * @throws Exception (File not Found)
     */
    public ArrayList<Item> loadItems (String s) throws Exception {

        File file = new File ("phase-1.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<Item> loadArray = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String entry = scanner.nextLine();
            String inputArray[] = entry.split("=");
            Item item = new Item(inputArray[0], Integer.parseInt(inputArray[1]));
            loadArray.add(item);
        }
        return loadArray;

    }

}
