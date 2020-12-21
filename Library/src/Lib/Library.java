package Lib;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final String nameOfLibrary;
    private final String address;
    private final List<Edition> editions;
    private final List<User> users;

    public Library(String nameOfLibrary, String address){
        this.nameOfLibrary = nameOfLibrary;
        this.address = address;
        editions = new ArrayList<>();
        users = new ArrayList<>();
    }

    public String getAddress() { return address; }

    public String getNameOfLibrary() { return nameOfLibrary; }

    public void saveDataInFile(){
        FileWriter fileWriterEdition = new FileWriter(".\\files\\Edition.csv");
        FileWriter fileWriterUsers = new FileWriter(".\\files\\Users.csv");

        StringFormatter<Edition> stringFormatter = new StringFormatter<>();
        String str = stringFormatter.getString(editions);
        fileWriterEdition.writeTextToFile(str);

        StringFormatter<User> stringFormatterOfUsers = new StringFormatter<>();
        str = stringFormatterOfUsers.getString(users);
        fileWriterUsers.writeTextToFile(str);
    }

    public void loadDataFromFile() {
        FileReader fileReaderEdition = new FileReader(".\\files\\Edition.csv");
        FileReader fileReaderUsers = new FileReader(".\\files\\Users.csv");

        String tableOfEdition = fileReaderEdition.toReadFile();
        if (tableOfEdition.length() > 1) {
            for (List<String> s : StringFormatter.createList(tableOfEdition)) {
                if (s.size() == 6) {
                    editions.add(new Book(s));
                }
                if (s.size() == 7) {
                    editions.add(new Magazine(s));
                }
            }
        }
        String tableOfUser = fileReaderUsers.toReadFile();
        if (tableOfUser.length() > 1) {
            for (List<String> s : StringFormatter.createList(tableOfUser)) {
                users.add(new User(s));
            }
        }
    }

    public void addEdition(Edition edition) { editions.add(edition); }

    public void addUserToList(User user) {
        users.add(user);
    }

    public String getEdition() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edition e :editions) {
            stringBuilder.append(e.getStringInfo());
        }
        return stringBuilder.toString();
    }

    public String getBooks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edition e :editions) {
            if (e instanceof Book) {
                stringBuilder.append(e.getStringInfo());
            }
        }
        return stringBuilder.toString();
    }

    public String getMagazines() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Edition e :editions) {
            if (e instanceof Magazine) {
                stringBuilder.append(e.getStringInfo());
            }
        }
        return stringBuilder.toString();
    }

    public void deleteEditionFromRegister(String name) {

        int index = findIndexEditionInList(name);

        if (index >= 0) {
            if (!editions.get(index).getIssue()) {
                editions.remove(index);
                System.out.println("The edition deleted");
            } else {
                System.out.println("Can`t delete this edition");
            }
        } else {
            System.out.println("Not found this edition in Register!");
        }
    }

    public boolean giveEditionToUser(String name, Integer numberUserTicket) {

        int index = findIndexEditionInList(name);
        Integer userIndex = findUser(numberUserTicket);

        if (index >= 0 && userIndex >= 0) {
            if (!editions.get(index).getIssue()) {
                editions.get(index).setIssue(true);
                users.get(userIndex).addEditionInTicket(editions.get(index).getName());
                return true;
            }
        }
        return false;
    }

    public boolean returnEditionToLibrary(String name, Integer numberUserTicket) {

        int index = findIndexEditionInList(name);
        Integer userIndex = findUser(numberUserTicket);

        if (index >= 0 && userIndex >= 0) {
            if (editions.get(index).getIssue()) {
                editions.get(index).setIssue(false);
                users.get(userIndex).deleteEditionFromTicket(name);
                return true;
            }
        }
        return false;
    }

    private Integer findUser(Integer numberOfLibraryTicket) {

        int index = -1;

        for (int i = 0; i < users.size(); i++) {
            if (numberOfLibraryTicket.equals(users.get(i).getNumberOfLibraryTicket())) {
                index = i;
            }
        }
        return index;
    }

    private Integer findIndexEditionInList(String name) {
        int index = -1;

        for (int i = 0; i < editions.size(); i++) {
            if (StringUtils.equals(editions.get(i).getName(), name)) {
                index = i;
            }
        }
        return index;
    }

    public void deleteUserFromRegister(int numberOfLibraryTicket) {
        int index = findUser(numberOfLibraryTicket);
        if (index >= 0) {
            if (users.get(index).getNameEditionInTicket().isEmpty()) {
                users.remove(index);
                System.out.println("The user deleted");
            } else {
                System.out.println("Can`t delete this user!");
            }
        } else {
            System.out.println("Not found this user in Register!");
        }
    }
}
