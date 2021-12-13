package com.examle.mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();

        Button button = new Button(mediator);
        Led led = new Led(mediator);
        PowerSwitch powerSwitch = new PowerSwitch(mediator);

        mediator.setButton(button);
        mediator.setLed(led);
        mediator.setPowerSwitch(powerSwitch);

        System.out.println("Button has been pressed");
        button.press();
        mediator.info();

        System.out.println("\nButton has been pressed");
        button.press();
        mediator.info();
    }
}