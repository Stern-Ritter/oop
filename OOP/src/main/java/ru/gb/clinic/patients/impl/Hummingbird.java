package ru.gb.clinic.patients.impl;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;
import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Flyable;

import java.time.LocalDate;

public class Hummingbird extends Animal implements Flyable {
    private static final double FLY_SPEED = 6;

    public Hummingbird(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    public Hummingbird() {
    }

    @Override
    public double fly() {
        return FLY_SPEED;
    }
}
