package ru.javarush.vasilev.cryptoanalizer;

import ru.javarush.vasilev.cryptoanalizer.controller.Cypher;

public class MainApp {
    public static void main(String... args){
        int key = 1;
        Cypher.encrypt("D:/test/src.txt", "D:/test/dst.txt", key);
        Cypher.decrypt("D:/test/dst.txt","D:/test/newdst.txt", key);
        Cypher.brutForce("D:/test/src.txt", "D:/test/brut/b/b/b");
    }
}