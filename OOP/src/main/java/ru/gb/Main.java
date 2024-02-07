package ru.gb;

import ru.gb.clinic.core.Clinic;
import ru.gb.clinic.core.VeterinaryClinic;
import ru.gb.clinic.drugstore.Pharmacy;
import ru.gb.clinic.drugstore.impl.Azithromycin;
import ru.gb.clinic.drugstore.impl.Penicillin;
import ru.gb.clinic.drugstore.impl.Water;
import ru.gb.clinic.patients.impl.Albatross;
import ru.gb.clinic.patients.impl.Cat;
import ru.gb.clinic.patients.impl.Dog;
import ru.gb.clinic.patients.impl.Hummingbird;
import ru.gb.clinic.patients.impl.Penguin;
import ru.gb.clinic.staff.impl.Doctor;
import ru.gb.clinic.staff.impl.Nurse;
import ru.gb.list.MyLinkedList;

import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        testMyLinkedList();
    }

    private static void testMyLinkedList() {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(1);
        myList.addAll(List.of(2, 4));
        myList.add(2, 3);
        myList.add(4);
        myList.set(4, 5);
        myList.addFirst(0);
        myList.addFirst(-1);
        myList.remove(-1);
        myList.remove(3);
        myList.remove(5);

        System.out.println("myList.get(0) = " + myList.get(0));
        System.out.println("myList.get(3) = " + myList.get(3));
        System.out.println("myList.contains(0) = " + myList.contains(0));
        System.out.println("myList.contains(5) = " + myList.contains(5));

        System.out.println("myList.isEmpty() = " + myList.isEmpty());
        System.out.println("myList.size() = " + myList.size());
        System.out.println(myList);

        myList.clear();
        System.out.println("myList.size() = " + myList.size());
        System.out.println(myList);
    }

    private static void secondTask() {
        Water water = new Water("Water", 10.0, 1);
        Azithromycin azithromycin = new Azithromycin("Azithromycin", 1.0, 8);
        Penicillin penicillin = new Penicillin("Penicillin", 0.8, 6);

        Pharmacy firstPharmacy = new Pharmacy("A");
        Pharmacy secondPharmacy = new Pharmacy("B");
        Pharmacy thirdPharmacy = new Pharmacy("C");

        firstPharmacy.addComponents(List.of(water, penicillin));
        secondPharmacy.addComponents(List.of(azithromycin));
        thirdPharmacy.addComponents(List.of(azithromycin, penicillin));

        List<Pharmacy> pharmacies = new ArrayList<>(List.of(firstPharmacy, secondPharmacy, thirdPharmacy));
        Collections.sort(pharmacies);
        System.out.println(pharmacies);

        pharmacies.sort(Comparator.comparingDouble(Pharmacy::getWeight));
        System.out.println(pharmacies);
    }

    private static void firstTask() {
        Clinic clinic = new VeterinaryClinic();

        Doctor firstDoctor = new Doctor(1L, "FirstDoctor", "FirstDoctorName",
                "FirstDoctorSurname", "FirstDoctorSpecialization");

        Doctor secondDoctor = new Doctor(2L, "SecondDoctor", "SecondDoctorName",
                "SecondDoctorSurname", "SecondDoctorSpecialization");

        Nurse firstNurse = new Nurse(3L, "FirstNurse", "FirstNurseName",
                "FirstNurseSurname", 1.0);

        Nurse secondNurse = new Nurse(4L, "SecondNurse", "SecondNurseName",
                "SecondNurseSurname", 2.0);

        clinic.hireStaff(firstDoctor);
        clinic.hireStaff(secondDoctor);
        clinic.hireStaff(firstNurse);
        clinic.hireStaff(secondNurse);

        System.out.println(clinic.getPersonal());

        clinic.dismissStaff(firstDoctor);
        clinic.dismissStaff(secondNurse);

        System.out.println(clinic.getPersonal());


        Cat cat = new Cat();
        Dog dog = new Dog();
        Hummingbird hummingbird = new Hummingbird();
        Penguin penguin = new Penguin();
        Albatross albatross = new Albatross();

        clinic.addPatient(cat);
        clinic.addPatient(dog);
        clinic.addPatient(hummingbird);
        clinic.addPatient(penguin);
        clinic.addPatient(albatross);

        System.out.println(clinic.getGoablePatients());
        System.out.println(clinic.getFlyablePatients());
        System.out.println(clinic.getSwimablePatients());
    }
}


