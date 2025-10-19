package com.testbank.andreas.integrationtest.dto;

import java.io.Serializable;
import java.util.Objects;

public class SpaceDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String nameSpace;
    private int maxPeople;
    private int Price;
    private boolean enabled;

    public SpaceDTO(){

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

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
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
        SpaceDTO spaceDTO = (SpaceDTO) o;
        return id == spaceDTO.id && maxPeople == spaceDTO.maxPeople && Price == spaceDTO.Price && enabled == spaceDTO.enabled && Objects.equals(nameSpace, spaceDTO.nameSpace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameSpace, maxPeople, Price, enabled);
    }
}
