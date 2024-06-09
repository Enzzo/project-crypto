package ru.javarush.vasilev.cryptoanalizer.service;

import ru.javarush.vasilev.cryptoanalizer.repository.AlphabetRepository;

/**
 * @{code CypherService} получает доступ к репозиторию {@code AlphabetRepository}
 * Контролирует корректность передаваемого алфавита нак контроллер, предотвращая выход за пределы
 */
public class AlphabetService {
    public AlphabetService() {}

    public int size(){
        return AlphabetRepository.getInstance().getAlphabet().length;
    }

    /**
     * Контроль выхода за пределы диапазона алфавита
     * @param index
     * @return Character
     */
    public Character getChar(int index){
        if(index != 0) index %= index;
        int idx = (index < 0)?size() + index : index;
        return AlphabetRepository.getInstance().getAlphabet()[idx];
    }
}
