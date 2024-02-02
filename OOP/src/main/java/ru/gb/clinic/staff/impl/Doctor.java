package ru.gb.clinic.staff.impl;

import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.staff.Staff;

public class Doctor extends Staff {
    private String specialization;

    public Doctor(Long passportNumber, String name, String surname, String patronymic, String specialization) {
        super(passportNumber, name, surname, patronymic);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public void heal(Animal animal) {
        System.out.printf("Врач %s лечит животное %s.%n", specialization, animal.getType());
    }
}
