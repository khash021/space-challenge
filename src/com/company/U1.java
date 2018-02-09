package com.company;

/**
 * The U-1 Rocket is light weight, agile and pretty safe, but can only carry a total of 18 tonnes of currentCargo. It
 * costs $60 Million to build and weighs 10 tonnes. It has a slim chance of crashing while landing but a bigger chance
 * of exploding when launching, both chances depend on the amount of currentCargo carried in the rocket.
 */


public class U1 extends Rocket {

    //Constructor: assigning values to Rocket Fields. All weights are in tonnes, and cost in Million $
    U1() {
        cost=100;
        rocketWeight=10;
        maxWeight=18;
        maxCargo = maxWeight - rocketWeight;
        currentCargo =0;
        probLaunchSuccess = 1 - (0.05 * (currentCargo /maxCargo));
        probLandSuccess = 1 - (0.01 * (currentCargo /maxCargo));
    }


    //launch method; return true if the launch was successful
    public boolean launch(int cargo) {
        int success = (int) (Math.random() * (probLaunchSuccess * 10));
        if (success >= 1) {
            rocketStatus = "launched";
            return true;
        } else {
            rocketStatus = "exploded";
            return false;
        }
    }

    //land method; return true if the landing was successful
    public boolean land(int cargo) {
        int success = (int) (Math.random() * (probLandSuccess * 10));
        if (success >= 1) {
            rocketStatus = "landed";
            return true;
        } else {
            rocketStatus = "crashed";
            return false;
        }
    }


}
