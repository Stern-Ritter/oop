package ru.gb.clinic.patients.impl;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;
import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Goable;
import ru.gb.clinic.patients.Swimable;

import java.time.LocalDate;

public class Cat extends Animal implements Goable, Swimable {
    private static final double RUN_SPEED = 10;
    private static final double SWIM_SPEED = 7;

    public Cat(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    public Cat() {
    }

    @Override
    public double run() {
        return RUN_SPEED;
    }

    @Override
    public double swim() {
        return SWIM_SPEED;
    }

    public static void meow() {
        System.out.println("Кошка мяукает.");
    }
}
