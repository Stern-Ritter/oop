package ru.gb.clinic.staff;

import ru.gb.clinic.patients.Animal;

import java.util.Objects;

public abstract class Staff {
    private final Long passportNumber;
    private final String name;
    private final String surname;
    private final String patronymic;

    public Staff(Long passportNumber, String name, String surname, String patronymic) {
        this.passportNumber = passportNumber;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Long getPassportNumber() {
        return passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public abstract void heal(Animal animal);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(passportNumber, staff.passportNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passportNumber);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "passportNumber=" + passportNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
