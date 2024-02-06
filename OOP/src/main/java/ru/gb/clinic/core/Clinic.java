package ru.gb.clinic.core;

import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Flyable;
import ru.gb.clinic.patients.Goable;
import ru.gb.clinic.patients.Swimable;
import ru.gb.clinic.staff.Staff;

import java.util.List;

public interface Clinic {
    void hireStaff(Staff staff);
    void dismissStaff(Staff staff);
    List<Staff> getPersonal();
    List<Animal> getPatients();

    <T extends Animal> void addPatient(T animal);
    List<Goable> getGoablePatients();
    List<Flyable> getFlyablePatients();
    List<Swimable> getSwimablePatients();
}
