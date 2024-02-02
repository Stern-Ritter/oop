package ru.gb.clinic.drugstore;

import java.util.Objects;

public class Component {
    private final String title;
    private final Double weight;
    private final Integer power;

    public Component(String title, Double weight, Integer power) {
        this.title = title;
        this.weight = weight;
        this.power = power;
    }

    public String getTitle() {
        return title;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(title, component.title) && Objects.equals(weight, component.weight) && Objects.equals(power, component.power);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, power);
    }

    @Override
    public String toString() {
        return "Component{" +
                "title='" + title + '\'' +
                ", weight=" + weight +
                ", power=" + power +
                '}';
    }
}
