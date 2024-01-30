package ru.gb.clinic.staff.impl;

import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.staff.Staff;

public class Nurse extends Staff {
    private Double workExperience;

    public Nurse(Long passportNumber, String name, String surname, String patronymic, Double workExperience) {
        super(passportNumber, name, surname, patronymic);
        this.workExperience = workExperience;
    }

    public Double getWorkExperience() {
        return workExperience;
    }

    public void increaseWorkExperience(long diff) {
        workExperience += diff;
    }

    @Override
    public void heal(Animal animal) {
        System.out.printf("Медсестра м опытом работы %.1f лет лечит животное", workExperience);
    }
}
