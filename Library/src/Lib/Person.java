package Lib;

import java.util.HashMap;

public abstract class Person implements Savable{
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public abstract HashMap<Integer, String> getInfo();
}
