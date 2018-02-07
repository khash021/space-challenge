package com.company;

public interface SpaceShip {

    //Method that return true or false indicating if the launch was successful, or the rocket has crashed
    boolean launch();

    //Method returning true or false based on the success of the landing
    boolean land();

    /*  Method that takes an Item object and returns true if the rocket can carry the items, or false if the load
        is too heavy
    */
    boolean canCarry(Item i);

    //Method that takes an Item object and updates the current weight of the rocket
    void carry(Item i);

}
