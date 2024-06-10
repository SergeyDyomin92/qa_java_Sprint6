package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getFelineKittensDefaultTest() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFelineKittensReturnsTest() {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void getFamilyTest() {
        String actualResult = feline.getFamily();
        String exceptedResult = "Кошачьи";
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    public void getEatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }

}
