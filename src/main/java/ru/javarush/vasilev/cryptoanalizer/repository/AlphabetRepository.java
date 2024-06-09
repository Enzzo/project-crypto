package ru.javarush.vasilev.cryptoanalizer.repository;

import java.util.Arrays;

/**
 * {@code AlphabetRepository} - репозиторий, содержащий алфавит
 */
public class AlphabetRepository {
    private static AlphabetRepository instance;
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    static{
        Arrays.sort(ALPHABET);
    }

    private AlphabetRepository() {
    }

    public static AlphabetRepository getInstance(){
        if(instance == null){
            instance = new AlphabetRepository();
        }
        return instance;
    }

    public char[] getAlphabet(){
        return ALPHABET;
    }
}
