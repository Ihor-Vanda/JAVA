package Lib;

import java.io.BufferedWriter;
import java.io.IOException;

class FileWriter {

    private final String fileName;

    public FileWriter(String fileName) {this.fileName = fileName;}

    public void writeTextToFile(String text) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(text);

        } catch (IOException exception) {

            System.out.println("File did not write");
        }

    }
}
