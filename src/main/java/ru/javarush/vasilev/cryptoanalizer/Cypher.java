package ru.javarush.vasilev.cryptoanalizer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cypher {
    // Алфавит не содержит буквы ё, й, ю и некоторые символы из задания:
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    static{
        // Сортируем алфавит для возможности бинарного поиска
        Arrays.sort(ALPHABET);
    }

    //  +---------------------------------------------------------------+
    //  |   Шифрует содержимое source и сохраняет в destination         |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstFile - файл, в который записывается зашифрованный        |
    //  |   результат                                                   |
    //  |   key - величина, на которую сдвигается исходный текст        |
    //  +---------------------------------------------------------------+
    public static void encrypt(File srcFile, File dstFile, int key){
        try(FileReader reader = new FileReader(srcFile);
            FileWriter os = new FileWriter(dstFile)){
            char[] buffer = new char[1024];
            int len = 0;
            while((len = reader.read(buffer)) > 0){
                for(int i = 0; i < len; ++i){
                    int idx = Arrays.binarySearch(ALPHABET, buffer[i]);
                    if(0 <= idx) {
                        int offs = roll(idx, key, ALPHABET.length);
                        buffer[i] = ALPHABET[offs];
                    }
                }
                os.write(buffer, 0, len);
            }
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    //  +---------------------------------------------------------------+
    //  |   Расшифровывает содержимое source и сохраняет в destination  |
    //  +---------------------------------------------------------------+
    //  |   srcFile - файл, содержащий исходный текст                   |
    //  |   dstFile - файл, в который записывается расшифрованный       |
    //  |   результат                                                   |
    //  |   key - величина, на которую сдвигается исходный текст        |
    //  +---------------------------------------------------------------+
    public static void decrypt(File srcFile, File dstFile, int key){
        encrypt(srcFile, dstFile, -key);
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
    public static void brutForce(File srcFile, File dstDir){
        try {
            if (!Files.exists(Path.of(dstDir.getPath()))) {
                Files.createDirectory(Path.of(dstDir.getPath()));
            }
        }
        catch(IOException e){
            System.out.printf("Can't create path<%s>\n", dstDir);
            return;
        }
        for(int i = 1; i < ALPHABET.length; ++i){
            String filePath = String.format("%s\\%2s.txt", dstDir.getPath(), i).replaceAll(" ", "0");
            File dstFile = new File(filePath);
            encrypt(srcFile, dstFile, i);
        }
    }

    public static void statisticalDecrypt(File sourceFile, File destination, int key){}

    //  +---------------------------------------------------------------+
    //  |   Смещает курсор на step символов                             |
    //  +---------------------------------------------------------------+
    //  |   pos - изначальная позиция курсора                           |
    //  |   step - шаг, на который должен быть смещён курсор            |
    //  |   size - общий размер (он же ограничитель) коллекции          |
    //  +---------------------------------------------------------------+
    //  |   return новую позицию курсора с учётом смещения (step)       |
    //  +---------------------------------------------------------------+
    private static int roll(int pos, int step, int size){
        //  если шаг отрицательный, то крутим курсор в обратном направлении
        if(step < 0){
            step = size + step % size;
        }
        int result = (pos + step) % size;
        return result;
    }
}
