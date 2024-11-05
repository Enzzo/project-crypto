package ru.javarush.vasilev.cryptoanalizer.controller;

import ru.javarush.vasilev.cryptoanalizer.service.Cypher;
import ru.javarush.vasilev.cryptoanalizer.service.FileManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CypherController {
    private final Cypher cypher = new Cypher();
    private final FileManager fm = new FileManager();
    private static Scanner cnsl;

//    private String src = "D:/test/2.txt";
//    private String dst = "D:/test/3.txt";
//    private Integer key = 1;

//    private String rootDirectory = new String();

    static{
        cnsl = new Scanner(System.in);
    }

    public CypherController(){}

    public void encrypt(){
        System.out.println("enter path of src then dst file");
        String src = cnsl.nextLine();
        String dst = cnsl.nextLine();
        Integer key = cnsl.nextInt();
        String sourceData = fm.readFile(src).orElseThrow();
        fm.writeFile(dst, cypher.encrypt(sourceData, key));
    }

    public void decrypt(){
        System.out.println("enter path of src then dst file");
        String src = cnsl.nextLine();
        String dst = cnsl.nextLine();
        Integer key = cnsl.nextInt();

        String sourceData = fm.readFile(src).orElseThrow();
        fm.writeFile(dst, cypher.decrypt(sourceData, key));
    }

    public void bruteforce(){

    }

    public void statisticAnalyze(){

    }
}