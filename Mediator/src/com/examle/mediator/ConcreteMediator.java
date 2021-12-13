package com.examle.mediator;

public class ConcreteMediator implements Mediator {
    private Button button;
    private Led led;
    private PowerSwitch powerSwitch;

    public void setButton(Button button) {
        this.button = button;
    }

    public void setLed(Led led) {
        this.led = led;
    }

    public void setPowerSwitch(PowerSwitch powerSwitch) {
        this.powerSwitch = powerSwitch;
    }

    public void press() {
        if (led.getIsOn()) {
            led.turnOff();
        } else {
            led.turnOn();
        }
    }

    public void electricityOn() {
        powerSwitch.turnOn();
    }

    public void electricityOff() {
        powerSwitch.turnOff();
    }

    public void info() {
        System.out.println("Electricity Supplied is On: " + powerSwitch.getElectricityIsSupplied());
        System.out.println("Led is On: " + led.getIsOn());
    }
}