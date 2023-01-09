package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Predator predator;

    public Lion(String sex, Feline feline) throws Exception {
        this.predator = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return predator.eatMeat();
    }

    public int getKittens(int kittensCount) {
        return predator.getKittens(kittensCount);
    }

}
