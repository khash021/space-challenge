package com.company;

public class U2 extends Rocket {

    //Fields. All weights are in tonnes, and cost in Million $
    final int cost = 200;
    final private int rocketWeight = 18;
    final private int maxWeight = 29;
    //maxCargo is the maximum weight of the cargo
    final private int maxCargo = maxWeight - rocketWeight;
    int cargo;


}
