package ru.gb.clinic;

import java.time.LocalDate;

public class Hummingbird extends Animal {
    public Hummingbird() {
    }

    public Hummingbird(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        super(nickName, owner, birthDate, illness);
    }

    @Override
    public void toGo() {
        System.out.println("Операция не поддерживается");
    }

    @Override
    public void fly() {
        System.out.println("Колибри летит");
    }

    @Override
    public void swim() {
        super.swim();
    }
}
