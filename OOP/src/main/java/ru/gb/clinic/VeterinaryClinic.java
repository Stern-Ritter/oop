package ru.gb.clinic;

import ru.gb.clinic.patients.Animal;
import ru.gb.clinic.patients.Flyable;
import ru.gb.clinic.patients.Goable;
import ru.gb.clinic.patients.Swimable;
import ru.gb.clinic.staff.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VeterinaryClinic implements Clinic {
    private final Map<Long, Staff> personal;
    private final Map<Long, Animal> patients;

    public VeterinaryClinic() {
        personal = new HashMap<>();
        patients = new HashMap<>();
    }

    public List<Staff> getPersonal() {
        return new ArrayList<>(personal.values());
    }

    public List<Animal> getPatients() {
        return new ArrayList<>(patients.values());
    }

    @Override
    public void hireStaff(Staff staff) {
        personal.putIfAbsent(staff.getPassportNumber(), staff);
    }

    @Override
    public void dismissStaff(Staff staff) {
        personal.remove(staff.getPassportNumber());
    }

    @Override
    public void addPatient(Animal animal) {
        patients.putIfAbsent(animal.getPassportNumber(), animal);
    }

    @Override
    public List<Goable> getGoablePatients() {
        return patients.values().stream()
                .filter((e) -> e instanceof Goable)
                .map((e) -> (Goable) e)
                .collect(Collectors.toList());
    }

    @Override
    public List<Flyable> getFlyablePatients() {
        return patients.values().stream()
                .filter((e) -> e instanceof Flyable)
                .map((e) -> (Flyable) e)
                .collect(Collectors.toList());
    }

    @Override
    public List<Swimable> getSwimablePatients() {
        return patients.values().stream()
                .filter((e) -> e instanceof Swimable)
                .map((e) -> (Swimable) e)
                .collect(Collectors.toList());
    }
}
