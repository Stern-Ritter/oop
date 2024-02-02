package ru.gb.clinic.drugstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pharmacy implements Comparable<Pharmacy>{
    private String name;
    private List<Component> components;

    public Pharmacy(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    private Pharmacy(List<Component> components) {
        this.components = components;
    }

    public void addComponents(List<Component> components) {
        this.components.addAll(components);
    }

    public void removeComponents(List<Component> components) {
        this.components.removeAll(components);
    }

    public Integer getPower() {
        return components.stream().mapToInt(Component::getPower).sum();
    }

    public Double getWeight() {
        return  components.stream().mapToDouble(Component::getWeight).sum();
    }

    @Override
    public int compareTo(Pharmacy o) {
        return Integer.compare(this.getPower(), o.getPower());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(name, pharmacy.name) && Objects.equals(components, pharmacy.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, components);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "name='" + name + '\'' +
                ", components=" + components +
                '}';
    }
}
