package Lib;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {

    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public String toReadFile(){

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader fileReader = new BufferedReader(new java.io.FileReader(fileName))){

            String currentLine;

            while ((currentLine = fileReader.readLine()) != null) {
                stringBuilder.append(currentLine).append(System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println("File did not read!!!");
        }

        return stringBuilder.toString();
    }
}

