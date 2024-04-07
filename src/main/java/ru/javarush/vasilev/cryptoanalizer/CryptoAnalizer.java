package ru.javarush.vasilev.cryptoanalizer;

import ru.javarush.vasilev.cryptoanalizer.Cypher;

import java.io.File;
public class CryptoAnalizer{
    public static void main(String... args){
        int key = 1;
        Cypher.encrypt(new File("D:/test/src.txt"), new File("D:/test/dst.txt"), key);
        Cypher.decrypt(new File("D:/test/dst.txt"), new File("D:/test/newdst.txt"), key);
        Cypher.brutForce(new File("D:/test/src.txt"), new File("D:/test/brut/b/b/b"));
    }
}