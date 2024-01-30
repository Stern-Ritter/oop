package ru.gb.clinic.patients;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;

import java.time.LocalDate;

public class Penguin extends Animal {
    public Penguin() {
    }

    public Penguin(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    @Override
    public void toGo() {
        System.out.println("Пингвин идет");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Пингвины не летают");
    }

    @Override
    public void swim() {
        System.out.println("Пингвин плывет");
    }
}
