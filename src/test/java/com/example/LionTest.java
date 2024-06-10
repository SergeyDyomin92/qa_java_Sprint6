package com.example;

import org.junit.Test;
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
    public void getLionKittensTest() {
        Lion lion = new Lion(feline);
        int exceptedResult = 5;
        Mockito.when(feline.getKittens()).thenReturn(exceptedResult);
        int actualResult = lion.getKittens();
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void getLionFoodTest() throws Exception {
        Lion lion = new Lion(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);

    }

    // Следующие два теста реализованы здесь и в LionParamTest
    @Test
    public void doesLionHaveManeTest() throws Exception {
        Lion lion = new Lion("Самец");
        boolean actualResult = lion.doesHaveMane();
        assertTrue(actualResult);
    }

    @Test
    public void doesLionHaveNotManeTest() throws Exception {
        Lion lion = new Lion("Самка");
        boolean actualResult = lion.doesHaveMane();
        assertFalse(actualResult);
    }

    @Test(expected = Exception.class)
    public void doesLionHaveManeDefaultExceptionTest() throws Exception {
        Lion lion = new Lion("Test");
        lion.doesHaveMane();
    }
}
