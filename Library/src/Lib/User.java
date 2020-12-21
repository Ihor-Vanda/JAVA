package Lib;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class User extends Person{
    private final String yearOfBird;
    private final Integer numberOfLibraryTicket;
    private List<String> nameEditionInTicket;

    public User(String firstName, String lastName, String yearOfBird, Integer numberOfLibraryTicket) {
        super(firstName, lastName);
        this.yearOfBird = yearOfBird;
        this.numberOfLibraryTicket = numberOfLibraryTicket;
        nameEditionInTicket = new ArrayList<>();
    }

    public User(List<String> data) {
        super(data.get(0), data.get(1));
        this.yearOfBird = data.get(2);
        this.numberOfLibraryTicket = Integer.parseInt(data.get(3));
        try {
            Collections.addAll(nameEditionInTicket, StringUtils.split(data.get(4), ","));
        } catch (NullPointerException e) {
            nameEditionInTicket = new ArrayList<>();
        }
    }

    public void addEditionInTicket(String name) {
        nameEditionInTicket.add(name);
    }

    public void deleteEditionFromTicket(String name) {
        nameEditionInTicket.remove(name);
    }

    public String getNameEditionInTicket() {
        StringBuilder stringBuilder = new StringBuilder();

        for (String string : nameEditionInTicket) {
            stringBuilder.append(string).append(",");
        }

        return stringBuilder.toString();
    }

    public Integer getNumberOfLibraryTicket() {
        return numberOfLibraryTicket;
    }

    public HashMap<Integer, String> getInfo() {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0, super.firstName);
        map.put(1, super.lastName);
        map.put(2, yearOfBird);
        map.put(3, String.valueOf(numberOfLibraryTicket));
        map.put(4, getNameEditionInTicket());

        return map;
    }
}
