package Lib;

import java.util.HashMap;
import java.util.List;

public abstract class Edition implements Savable {
    protected String name;
    private final List<String> authors;
    protected Integer numberOfPage;
    protected String publisher;
    protected boolean isIssued;

    public Edition(String name, List<String> authors, Integer numberOfPage, String publisher, boolean isIssued) {
        this.name = name;
        this.authors = authors;
        this.numberOfPage = numberOfPage;
        this.publisher = publisher;
        this.isIssued = isIssued;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getNumberOfPage() {
        return String.valueOf(numberOfPage);
    }

    public String getAuthors() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;

        for (String author : authors) {
            stringBuilder.append(author);
            if (count < authors.size() - 1) {
                stringBuilder.append(",");
            }
            count++;
        }

        return stringBuilder.toString();
    }

    public boolean getIssue() {
        return isIssued;
    }

    public void setIssue(boolean bool) {
        isIssued = bool;
    }

    public abstract HashMap<Integer, String> getInfo();

    public abstract String getStringInfo();
}
