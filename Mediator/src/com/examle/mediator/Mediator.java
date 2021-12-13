package com.examle.mediator;

public interface Mediator {
    void press();
    void setButton(Button button);
    void setLed(Led led);
    void setPowerSwitch(PowerSwitch powerSwitch);
    void electricityOn();
    void electricityOff();
    void info();
}