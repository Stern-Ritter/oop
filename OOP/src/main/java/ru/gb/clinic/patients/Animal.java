package ru.gb.clinic.patients;

import ru.gb.clinic.illnesses.Illness;
import ru.gb.clinic.owners.Owner;

import java.time.LocalDate;

public abstract class Animal {
    private static long currentPassportNumber = 0;
    private final Long passportNumber;
    private String nickName;
    private Owner owner;
    private LocalDate birthDate;
    private Illness illness;

    public Animal(Long passportNumber, String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        this.passportNumber = passportNumber;
        this.nickName = nickName;
        this.owner = owner;
        this.birthDate = birthDate;
        this.illness = illness;
    }

    public Animal(String nickName, Owner owner, LocalDate birthDate, Illness illness) {
        this.passportNumber = getCurrentPassportNumber();
        this.nickName = nickName;
        this.owner = owner;
        this.birthDate = birthDate;
        this.illness = illness;
    }

    public Animal() {
        this(getCurrentPassportNumber(), "Кличка", new Owner("Хозяин"), LocalDate.now(),
                new Illness("Болеет"));
    }

    private static long getCurrentPassportNumber() {
        return ++currentPassportNumber;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public String getNickName() {
        return nickName;
    }

    public Owner getOwner() {
        return owner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public String getType() {
        return getClass().getSimpleName();
    }

    private void eat() {
        System.out.println("Животное ест.");
    }

    private void sleep() {
        System.out.println("Животное уснуло.");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + getType() +
                ", passportNumber=" + passportNumber +
                ", nickName='" + nickName + '\'' +
                ", owner=" + owner +
                ", birthDate=" + birthDate +
                ", illness=" + illness +
                '}';
    }
}