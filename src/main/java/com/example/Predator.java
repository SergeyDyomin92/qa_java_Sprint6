package com.example;

import java.util.List;

public interface Predator {

    List<String> eatMeat() throws Exception;

    int getKittens();

    List<String> getFood(String animalKind) throws Exception;
}