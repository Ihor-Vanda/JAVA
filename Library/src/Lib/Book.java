package Lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Book extends Edition{
    private final Integer yearOfPublication;

    public Book(String name, List<String> authors, Integer numberOfPage, String publisher, Integer yearOfPublication, boolean isIssued) {
        super(name, authors, numberOfPage, publisher, isIssued);
        this.yearOfPublication = yearOfPublication;
    }

    public Book(List<String> data){
        super(data.get(0), Arrays.asList(data.get(1).split(",")),Integer.parseInt(data.get(2)),data.get(3), Boolean.parseBoolean(data.get(5)));
        this.yearOfPublication = Integer.parseInt(data.get(4));
    }

    public String getStringInfo() {
        return "Name: " + getName() + "\n" + "Authors: " +
                getAuthors() + "\n" + "Number of page: " +
                getNumberOfPage() + "\n" + "Publisher: " +
                getPublisher() + "\n" + "Year of publication: " +
                yearOfPublication + "\n\n";
    }

    public HashMap<Integer, String> getInfo() {

        HashMap<Integer,String> map = new HashMap<>();
        map.put(0, name);
        map.put(1, getAuthors());
        map.put(2, getNumberOfPage());
        map.put(3, publisher);
        map.put(4, String.valueOf(yearOfPublication));
        map.put(5, String.valueOf(super.isIssued));

        return map;
    }
}
