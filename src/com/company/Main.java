package com.company;

public class Main {


    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws Exception {

        String rocket = "u1";
        int phase = 2;
        Simulation simulation = new Simulation();
        print("Phase: " + phase + "\nRocket: " + rocket + "\nTotal cost of the mission: " +
                simulation.runSimulation(rocket, phase) + " $ million");

    }
}
