package ru.gb;

import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Hummingbird;
import ru.gb.clinic.patients.Penguin;

public class Main {
    public static void main(String[] args) {
        Animal firstAnimal = new Penguin();
        Animal secondAnimal = new Hummingbird();

        System.out.println(firstAnimal);
        System.out.println(secondAnimal);

        firstAnimal.toGo();
        try {
            firstAnimal.fly();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
        firstAnimal.swim();

        secondAnimal.toGo();
        secondAnimal.fly();
        secondAnimal.swim();
    }
}


