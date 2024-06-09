package ru.javarush.vasilev.cryptoanalizer.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validator {
    public boolean isFileExists(String fileName){
        Path filePath = Paths.get(fileName);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }
}
