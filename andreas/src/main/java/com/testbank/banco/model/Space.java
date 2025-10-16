package com.testbank.banco.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="space")
public class Space implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name_space", nullable = false, length = 100)
    private String nameSpace;

    @Column(name="max_people", nullable = false)
    private int maxPeople;

    @Column(name="price", nullable = false)
    private int Price;

    @Column(nullable = false)
    private boolean enabled;

    public Space() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Space space = (Space) o;
        return getId() == space.getId() && getMaxPeople() == space.getMaxPeople() && getPrice() == space.getPrice() && isEnabled() == space.isEnabled() && Objects.equals(getNameSpace(), space.getNameSpace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameSpace(), getMaxPeople(), getPrice(), isEnabled());
    }
}
