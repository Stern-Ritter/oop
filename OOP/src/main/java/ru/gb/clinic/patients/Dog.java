package ru.gb.clinic.patients;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;

import java.time.LocalDate;

public class Dog extends Animal {
    public Dog(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    public Dog() {
        super();
    }
}
