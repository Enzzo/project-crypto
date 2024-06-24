package ru.javarush.vasilev.cryptoanalizer.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    public void prompt(){
        System.out.println("Select an option:");
        System.out.println("1: encrypt");
        System.out.println("2: decrypt");
        System.out.println("3: brutforce");
        System.out.println("4: statistic analyze");
        System.out.println("0: exit");
    }

    public int getOption(){
        try{
            return new Scanner(System.in).nextInt();
        }catch(InputMismatchException e){
            System.out.println("Input error");
            return getOption();
        }
    }
}