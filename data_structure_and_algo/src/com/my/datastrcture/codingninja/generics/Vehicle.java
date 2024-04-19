package com.my.datastrcture.codingninja.generics;

public class Vehicle {
    private int maxSpeed;
    private String companyName;

    public Vehicle(int maxSpeed, String companyName) {
        this.maxSpeed = maxSpeed;
        this.companyName = companyName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "maxSpeed=" + maxSpeed +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
