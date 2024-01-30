package ru.gb.clinic.patients;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;

import java.time.LocalDate;

public class Cat extends Animal {
    Double discount;

    public Cat(String nickName, Owner owner, LocalDate birthDate, Illness illness, Double discount) {
        super(nickName, owner, birthDate, illness);
        this.discount = discount;
    }

    public Cat() {
        super();
        this.discount = 10D;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public static void meow() {
        System.out.println("Мяяяу!");
    }

    @Override
    public String toString() {
        return super.toString() + "Discount(" + discount + ")";
    }
}
