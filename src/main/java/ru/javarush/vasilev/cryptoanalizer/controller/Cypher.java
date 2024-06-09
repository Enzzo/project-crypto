package ru.javarush.vasilev.cryptoanalizer.controller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cypher {

    //  +---------------------------------------------------------------+
    //  |   Шифрует содержимое source и сохраняет в destination         |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstFile - файл, в который записывается зашифрованный        |
    //  |   результат                                                   |
    //  |   key - величина, на которую сдвигается исходный текст        |
    //  +---------------------------------------------------------------+
    private static void crypt(String srcFile, String dstFile, int key){

        Path path = Paths.get(srcFile);
        try{
            byte[] bytes = Files.readAllBytes(path);
            FileWriter os = new FileWriter(dstFile);
            int len = 0;
//            while((len = reader.read(buffer)) > 0){
//                for(int i = 0; i < len; ++i){
//                    int idx = Arrays.binarySearch(ALPHABET, buffer[i]);
//                    if(0 <= idx) {
//                        int offs = roll(idx, key, ALPHABET.length);
//                        buffer[i] = ALPHABET[offs];
//                    }
//                }
//                os.write(buffer, 0, len);
//            }
        }
        catch(IOException ignore){}
    }

    public static void encrypt(String srcFile, String dstFile, int key){
        crypt(srcFile, dstFile, key);
    }

    //  +---------------------------------------------------------------+
    //  |   Расшифровывает содержимое source и сохраняет в destination  |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstFile - файл, в который записывается расшифрованный       |
    //  |   результат                                                   |
    //  |   key - величина, на которую сдвигается исходный текст        |
    //  +---------------------------------------------------------------+
    public static void decrypt(String srcFile, String dstFile, int key){
        crypt(srcFile, dstFile, -key);
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
    public static void brutForce(String srcFile, String dstDir){
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
