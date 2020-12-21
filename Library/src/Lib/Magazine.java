package Lib;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Magazine extends Edition {
    private final String dateOfPublication;
    private final Integer numberOfArticle;

    public Magazine(String name, List<String> authors, Integer numberOfaPage, String publisher, String dateOfPublication, Integer numberOfArticle, boolean isIssued) {
        super(name, authors, numberOfaPage, publisher, isIssued);
        this.dateOfPublication = dateOfPublication;
        this.numberOfArticle = numberOfArticle;
    }

    public Magazine(List<String> data){
        super(data.get(0), Arrays.asList(data.get(1).split(",")),Integer.parseInt(data.get(2)),data.get(3), Boolean.parseBoolean(data.get(6)));
        this.dateOfPublication = data.get(4);
        this.numberOfArticle = Integer.parseInt(data.get(5));
    }

    public String getStringInfo() {
        return "Name: " + getName() + "\n" + "Authors: " +
                getAuthors() + "\n" + "Number of page: " +
                getNumberOfPage() + "\n" + "Publisher: " +
                getPublisher() + "\n" + "Date of publication: " +
                dateOfPublication + "\n" + "Number of article: " +
                numberOfArticle + "\n\n";
    }

    public HashMap<Integer, String> getInfo() {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(0, super.name);
        map.put(1, super.getAuthors());
        map.put(2, super.getNumberOfPage());
        map.put(3, super.publisher);
        map.put(4, dateOfPublication);
        map.put(5, String.valueOf(numberOfArticle));
        map.put(6, String.valueOf(super.isIssued));

        return map;
    }
}
