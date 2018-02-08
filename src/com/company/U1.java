package com.company;

public class U1 extends Rocket {

    //Fields. All weights are in tonnes, and cost in Million $
    final int cost = 100;
    final int rocketWeight = 10;
    final int maxWeight = 18;
    //maxCargo is the maximum weight of the cargo
    final int maxCargo = maxWeight - rocketWeight;
    int cargo;

    //Override the launch method so we can simulate if the launch will be successful, or result in a crash
    @Override
    //need to change this later to take an Item object as an input not hte cargo weight
    public boolean launch(int cargo) {
        double chance = (cargo / this.maxCargo) * (1 - 0.05);
        int success = (int) (Math.random() * (chance * 10));
        if (success>=1) {
            return true;
        } else {
            return false;
        }
    }
}
