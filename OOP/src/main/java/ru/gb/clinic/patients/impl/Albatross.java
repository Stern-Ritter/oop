package ru.gb.clinic.patients.impl;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;
import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Flyable;
import ru.gb.clinic.patients.Goable;
import ru.gb.clinic.patients.Swimable;

import java.time.LocalDate;

public class Albatross extends Animal implements Goable, Flyable, Swimable {
    private static final double RUN_SPEED = 3;
    private static final double FLY_SPEED = 7;
    private static final double SWIM_SPEED = 7;


    public Albatross(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    public Albatross() {
    }

    @Override
    public double fly() {
        return FLY_SPEED;
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
