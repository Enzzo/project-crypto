package ru.javarush.vasilev.cryptoanalizer.repository;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.internal.matchers.NotNull;
import ru.javarush.vasilev.cryptoanalizer.service.AlphabetService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AlphabetRepositoryTest {
    private static AlphabetService alphabetService;

    @BeforeAll
    static void setup(){
        alphabetService = new AlphabetService();
    }

    @DisplayName("Test Service size")
    @Test
    void testSize(){
        assertNotEquals(0, alphabetService.size());
        assertEquals(40, alphabetService.size());
    }

    @DisplayName("Test get char by different idx")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 1000, -1000})
    void testGetChar(int idx){
        Integer magicIdx = alphabetService.size() * idx + idx;
        Character c1 = alphabetService.getChar(magicIdx);
        Character c2 = alphabetService.getChar(idx);
        assertEquals(alphabetService.getChar(idx), alphabetService.getChar(magicIdx));
    }
}