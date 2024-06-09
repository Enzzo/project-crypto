package ru.javarush.vasilev.cryptoanalizer.controller;

import org.apache.commons.lang3.StringUtils;

public class FileManager {
    private Validator validator;

    public FileManager() {
        this.validator = new Validator();
    }

    public String readFile(String filePath){
        if(StringUtils.isEmpty(filePath))
        return null;
    }
    public void writeFile(String filePath, String content){

    }
}
