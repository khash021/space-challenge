package com.company;

public class Rocket implements SpaceShip {

    //Declare variables and set to zero. U1 and U2 which are the children will overwrite them
    int cost=0;
    int rocketWeight=0;
    int maxWeight=0;
    int currentCargo =0;        //Current currentCargo weight of the Rocket
    int maxCargo = maxWeight - rocketWeight;
    int availableCargo = maxCargo - currentCargo;

    double probLaunchSuccess=0.0;
    double probLandSuccess=0.0;

    String rocketStatus = "not loaded";             // not loaded, loaded, exploded, launched, crashed, landed

    //U1 and U2 will override launch and land methods using their weight and probabilities.
    public boolean launch() {
        return true;
    }
    public boolean land(){
        return true;
    }

    //This method takes an Item and return true if the Rocket can carry that Item
    public boolean canCarry(Item i) {
        if(i.weight <= availableCargo) {
            return true;
        } else {
            return false;
        }
    }

    //This method takes an Item object and update the current weight of the Rocket
    public void carry(Item i) {
        currentCargo += i.weight;
    }

}
