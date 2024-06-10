package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {

    @Parameterized.Parameter
    public String sex;
    @Parameterized.Parameter(1)
    public boolean doesHaveMane;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void lionManeParamTest() throws Exception {

        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(doesHaveMane, actual);
    }
}
