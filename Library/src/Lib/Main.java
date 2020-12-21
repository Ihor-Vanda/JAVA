package Lib;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Library library;
    public static void main(String[]args) {
        library = new Library("Lib", "Address");
        while (true){

            System.out.println("\n1 - Add to Library" +
                    "\n2 - Delete from Library" +
                    "\n3 - Show all editions" +
                    "\n4 - Show all book" +
                    "\n5 - Show all magazine" +
                    "\n6 - Give edition to user" +
                    "\n7 - Return edition to library" +
                    "\n8 - Read from file" +
                    "\n9 - Write to file" +
                    "\n0 - Exit");
            String operation = scanner.nextLine();

            switch (operation) {
                case "1":
                    System.out.println("1 - Add book" +
                            "\n2 - Add magazine" +
                            "\n3 - Add user");
                    String typeOfEdition = scanner.nextLine();
                    addToLibrary(typeOfEdition);
                break;
                case "2":
                    System.out.println("1 - Delete edition" +
                            "\n2 - Delete user");
                    String typeOfDeleting = scanner.nextLine();
                    switch (typeOfDeleting) {
                        case "1":
                            System.out.println("Enter name edition for deleting: ");
                            String nameOfEdition = scanner.nextLine();

                            library.deleteEditionFromRegister(nameOfEdition);
                            break;
                        case "2":
                            String numberOfUserTicket = "";

                            while (!StringUtils.isNumeric(numberOfUserTicket)) {
                                System.out.println("Enter number of users ticket: ");
                                numberOfUserTicket = scanner.nextLine();
                            }
                            library.deleteUserFromRegister(Integer.parseInt(numberOfUserTicket));
                            break;
                        default: System.out.println("It`s incorrect choice!");
                    }
                break;
                case "3":
                    System.out.println(library.getEdition());
                break;
                case "4":
                    System.out.println(library.getBooks());
                break;
                case "5":
                    System.out.println(library.getMagazines());
                break;
                case "6":
                    System.out.println("Enter name edition for giving up: ");
                    String nameOfEdition = scanner.nextLine();

                    String numberOfUserTicket = "";

                    while (!StringUtils.isNumeric(numberOfUserTicket)) {
                        System.out.println("Enter number of users ticket: ");
                        numberOfUserTicket = scanner.nextLine();
                    }

                    if (library.giveEditionToUser(nameOfEdition, Integer.parseInt(numberOfUserTicket))) {
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Can`t issue this edition to this user!");
                    }
                    break;
                case "7":
                    System.out.println("Enter name edition for return: ");
                    nameOfEdition = scanner.nextLine();

                    numberOfUserTicket = "";

                    while (!StringUtils.isNumeric(numberOfUserTicket)) {
                        System.out.println("Enter number of users ticket: ");
                        numberOfUserTicket = scanner.nextLine();
                    }

                    if (library.returnEditionToLibrary(nameOfEdition, Integer.parseInt(numberOfUserTicket))) {
                        System.out.println("Successfully");
                    } else {
                        System.out.println("Can`t return this edition from this user!");
                    }
                    break;
                case "8":
                    library.loadDataFromFile();
                    break;
                case "9":
                    library.saveDataInFile();
                    break;
                case "0":
                    return;
                default: System.out.println("Incorrect choice!");
            }
        }
    }

    public static void addToLibrary(String type) {

        if (!type.equals("3")) {
            System.out.println("Enter name of edition: ");
            String name = scanner.nextLine();

            String numberOfAuthors = "";
            while (!StringUtils.isNumeric(numberOfAuthors)) {
                System.out.println("Enter number of Authors: ");
                numberOfAuthors = scanner.nextLine();
                if (StringUtils.isNumeric(numberOfAuthors)) {
                    if (Integer.parseInt(numberOfAuthors) <= 0) {
                        numberOfAuthors = "";
                    }
                }
            }

            List<String> authors = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(numberOfAuthors); i++) {
                System.out.println("Enter First name Author: ");
                String firstName = scanner.nextLine();
                System.out.println("Enter Last name Author: ");
                String lastName = scanner.nextLine();
                Author author = new Author(firstName, lastName);
                authors.add(author.getFullNameInString());
            }

            String numberOfPage = "";

            while (!StringUtils.isNumeric(numberOfPage)) {
                System.out.println("Enter number of page: ");
                numberOfPage = scanner.nextLine();
                if (StringUtils.isNumeric(numberOfPage)) {
                    if (Integer.parseInt(numberOfPage) <= 0) {
                        numberOfPage = "";
                    }
                }
            }

            System.out.println("Enter name of publisher: ");
            String publisher = scanner.nextLine();

            if (type.equals("1")) {
                String yearOfPublication = "";

                while (!StringUtils.isNumeric(yearOfPublication)) {
                    System.out.println("Enter year of publication: ");
                    yearOfPublication = scanner.nextLine();
                    if (StringUtils.isNumeric(yearOfPublication)) {
                        if (Integer.parseInt(yearOfPublication) <= 0) {
                            yearOfPublication = "";
                        }
                    }
                }

                Book book = new Book(name, authors, Integer.parseInt(numberOfPage),
                        publisher, Integer.parseInt(yearOfPublication), false);
                library.addEdition(book);
            } else if (type.equals("2")) {

                System.out.println("Enter date of publication: ");
                String dateOfPublication = scanner.nextLine();

                String numberOfArticle = "";

                while (!StringUtils.isNumeric(numberOfArticle)) {
                    System.out.println("Enter number of Article: ");
                    numberOfArticle = scanner.nextLine();
                    if (StringUtils.isNumeric(numberOfArticle)) {
                        if (Integer.parseInt(numberOfArticle) <= 0) {
                            numberOfArticle = "";
                        }
                    }
                }

                Magazine magazine = new Magazine(name, authors, Integer.parseInt(numberOfPage),
                        publisher, dateOfPublication, Integer.parseInt(numberOfArticle), false);
                library.addEdition(magazine);
            } else {
                System.out.println("Operation hasn`t define!");
            }
        } else {
            addUser();
        }
    }
    public static void addUser() {

        System.out.println("Enter user`s first name: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter user`s last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter year of bird user: ");
        String dataOfBirds = scanner.nextLine();

        String numberOfLibraryTicket = "";

        while (!StringUtils.isNumeric(numberOfLibraryTicket)) {
            System.out.println("Enter number of library ticket: ");
            numberOfLibraryTicket = scanner.nextLine();
            if (StringUtils.isNumeric(numberOfLibraryTicket)) {
                if (Integer.parseInt(numberOfLibraryTicket) <= 0) {
                    numberOfLibraryTicket = "";
                }
            }
        }

        User user = new User(firstName, lastName, dataOfBirds,
                Integer.parseInt(numberOfLibraryTicket));

        library.addUserToList(user);
    }
}
