package ru.javarush.vasilev.cryptoanalizer.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public FileManager() {}

    public String readFile(String filePath){
        if(Validator.isFileExists(filePath)){
            Path src = Paths.get(filePath);
            try {
                StringBuffer result = new StringBuffer();
                for(String line : Files.readAllLines(src)){
                    result.append(line).append('\n');
                }
                return result.toString();
            }catch(IOException e){
                System.out.println("can't read file");
            }
        }
        System.out.printf("%s - is not a file\n", filePath);
        return null;
    }
    public void writeFile(String filePath, String content){
        try(FileWriter writer = new FileWriter(filePath)){
            writer.write(content);
        }catch(IOException e){

        }
    }
}
