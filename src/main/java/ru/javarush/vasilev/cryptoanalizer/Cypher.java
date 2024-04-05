package ru.javarush.vasilev.cryptoanalizer;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cypher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public static void encrypt(File source, File destination, int key)throws IOException{
        try(FileReader reader = new FileReader(source);
            FileWriter os = new FileWriter(destination)){

            char[] buffer = new char[1024];
            int len = 0;
            while((len = reader.read(buffer)) > 0){
                // TODO: сдвигаем, а затем записывавем в файл-назначение:

                for(int i = 0; i < len; ++i){
                    for(int j = 0; j < ALPHABET.length; ++j){
                        char ch = buffer[i];
                        char alp = ALPHABET[j];
                        if(ch == alp){
                            int off = (j + key) % (ALPHABET.length);
                            buffer[i] = ALPHABET[off];
                            break;
                        }
                    }
                }

                os.write(buffer, 0, len);
            }
        }
    }
    public static void decrypt(File source, File destination, int key){}
    public static void brutForce(File source, File destination, int key){}
    public static void statisticalDecrypt(File source, File destination, int key){}
}
