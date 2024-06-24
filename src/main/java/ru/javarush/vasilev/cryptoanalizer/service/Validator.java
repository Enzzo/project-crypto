package ru.javarush.vasilev.cryptoanalizer.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {
    public static boolean isFileExists(String fileName){
        Path filePath = Paths.get(fileName);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }
}
