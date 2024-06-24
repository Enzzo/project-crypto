package ru.javarush.vasilev.cryptoanalizer.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Cypher {
    private final AlphabetService alphabet = new AlphabetService();
    private final Bruteforce bf = new Bruteforce();
    private final StatisticalAnalyzer st = new StatisticalAnalyzer();

    /**
     *
     * @param srcFile путь к файлу, содержащему исходный текст
     * @param dstFile путь к файлу, содержащему результат
     * @param key величина, на которую сдвигается исходный текст
     */
    public String crypt(String src, int key){
        String crypted = new String();
        for(int i = 0; i < src.length(); ++i){
            char ch = src.charAt(i);
            int idx = Arrays.binarySearch(alphabet.getAlphabet(), ch);
            if(0 <= idx){
                ch = alphabet.getChar(idx + key);
            }
            crypted += ch;
        }
        return crypted;
    }

    public String encrypt(String src, int key){
        return crypt(src, key);
    }

    //  +---------------------------------------------------------------+
    //  |   Расшифровывает содержимое source и сохраняет в destination  |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstFile - файл, в который записывается расшифрованный       |
    //  |   результат                                                   |
    //  |   key - величина, на которую сдвигается исходный текст        |
    //  +---------------------------------------------------------------+
    public String decrypt(String src, int key){
        return crypt(src, -key);
    }

    //  +---------------------------------------------------------------+
    //  |   Перебирает все возможные расшифрованные варианты исходного  |
    //  |   файла                                                       |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstDir  - папка, в которую будут сохранены результаты брута |
    //  +---------------------------------------------------------------+
    //  |   Если директории назначения не существует, то метод создаёт  |
    //  |   эту директорию.                                             |
    //  |   Если директорию создать невозможно, то метод завершается    |
    //  |   без результата                                              |
    //  |   В директории назначения создаются файлы-результаты брута    |
    //  +---------------------------------------------------------------+
    public static void bruteForce(String srcFile, String dstDir){
        try {
            Path dstPath = Paths.get(dstDir);
            if (!Files.exists(dstPath)) {
                Files.createDirectory(dstPath);
            }
        }
        catch(IOException e){
            System.out.printf("Can't create path<%s>\n", dstDir);
            return;
        }
//        for(int i = 1; i < ALPHABET.length; ++i){
//            String filePath = String.format("%s\\%2s.txt", dstDir.getPath(), i).replaceAll(" ", "0");
//            File dstFile = new File(filePath);
//            encrypt(srcFile, dstFile, i);
//        }
    }

    public static void statisticalDecrypt(File sourceFile, File destination, int key){}
}
