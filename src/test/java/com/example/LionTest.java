package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getLionKittensTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int exceptedResult = 5;
        Mockito.when(feline.getKittens()).thenReturn(exceptedResult);
        int actualResult = lion.getKittens();
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void getLionFoodTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);

    }

    // Следующие два теста реализованы здесь и в LionParamTest
    @Test
    public void doesLionHaveManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean actualResult = lion.doesHaveMane();
        assertTrue(actualResult);
    }

    @Test
    public void doesLionHaveNotManeTest() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean actualResult = lion.doesHaveMane();
        assertFalse(actualResult);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void doesLionHaveManeDefaultExceptionTest() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion(feline, "Test");
        lion.doesHaveMane();
    }
}
