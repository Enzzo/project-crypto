package ru.javarush.vasilev.cryptoanalizer;

import ru.javarush.vasilev.cryptoanalizer.controller.CypherController;
import ru.javarush.vasilev.cryptoanalizer.view.View;

import java.util.Scanner;

public class MainApp {

    public static void main(String... args){
        View view = new View();
        CypherController cypher = new CypherController();

        while(true){
            view.prompt();
            switch(view.getOption()){
                case 1: cypher.encrypt();
                        break;
                case 2: cypher.decrypt();
                        break;
                case 3: cypher.bruteforce();
                        break;
                case 4: cypher.statisticAnalyze();
                        break;
                default: return;
            }
        }
    }
}