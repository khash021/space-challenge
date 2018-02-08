package com.company;

/**
 * The U2 Rocket heavier than the U-1 but much safer and can carry a lot more currentCargo; to a total of 29 tonnes. However,
 * it costs $120 Million to build and weighs 20 tonnes. It has a greater chance of crashing while landing than while
 * launching, but just like the U-1 both chances depend on the amount of currentCargo carried.
 */

public class U2 extends Rocket {

    //Constructor: assigning values to Rocket Fields. All weights are in tonnes, and cost in Million $
    U2 () {
        cost=120;
        rocketWeight=18;
        maxWeight=29;
        maxCargo = maxWeight - rocketWeight;
        currentCargo =0;
        probLaunchSuccess = 1 - (0.04 * (currentCargo /maxCargo));
        probLandSuccess = 1 - (0.08 * (currentCargo /maxCargo));
    }


    //Launch method; return true if the launch was successful
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
