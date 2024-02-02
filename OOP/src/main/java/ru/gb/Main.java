package ru.gb;

import ru.gb.clinic.Clinic;
import ru.gb.clinic.VeterinaryClinic;
import ru.gb.clinic.patients.impl.Albatross;
import ru.gb.clinic.patients.impl.Cat;
import ru.gb.clinic.patients.impl.Dog;
import ru.gb.clinic.patients.impl.Hummingbird;
import ru.gb.clinic.patients.impl.Penguin;
import ru.gb.clinic.staff.impl.Doctor;
import ru.gb.clinic.staff.impl.Nurse;

public class Main {
    public static void main(String[] args) {
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


