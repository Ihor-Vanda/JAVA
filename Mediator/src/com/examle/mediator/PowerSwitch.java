package com.examle.mediator;

public class PowerSwitch {
    private final Mediator mediator;
    private boolean electricityIsSupplied = false;

    public PowerSwitch(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean getElectricityIsSupplied() { return electricityIsSupplied; }

    public void turnOn() {
        electricityIsSupplied = true;
    }

    public void turnOff() {
        electricityIsSupplied = false;
    }
}