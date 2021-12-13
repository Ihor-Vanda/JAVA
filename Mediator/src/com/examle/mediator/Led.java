package com.examle.mediator;

public class Led {
    private final Mediator mediator;
    private boolean isOn = false;

    public Led(Mediator mediator) {
        this.mediator = mediator;
    }

    public boolean getIsOn() { return isOn; }

    public void turnOn() {
        mediator.electricityOn();
        isOn = true;
    }

    public void turnOff() {
        mediator.electricityOff();
        isOn = false;
    }
}