package Lib;

import java.util.HashMap;

public class Author extends Person {

    public Author(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public String getFullNameInString() {
        return firstName + " " + lastName;
    }

    public HashMap<Integer, String> getInfo() {
        java.util.HashMap<java.lang.Integer, java.lang.String> map = new HashMap<>();
        map.put(0, super.firstName);
        map.put(1, super.lastName);

        return map;
    }
}
