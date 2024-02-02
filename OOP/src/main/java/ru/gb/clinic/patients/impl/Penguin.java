package ru.gb.clinic.patients.impl;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;
import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Goable;
import ru.gb.clinic.patients.Swimable;

import java.time.LocalDate;

public class Penguin extends Animal implements Goable, Swimable {
    private static final double RUN_SPEED = 3;
    private static final double SWIM_SPEED = 12;

    public Penguin(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    public Penguin() {
    }

    @Override
    public double run() {
        return RUN_SPEED;
    }

    @Override
    public double swim() {
        return SWIM_SPEED;
    }
}
