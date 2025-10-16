package com.testbank.banco.data.dto;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

public class SpaceDTO extends RepresentationModel<SpaceDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String nameSpace;
    private int maxPeople;
    private int Price;
    private boolean enabled;

    public SpaceDTO() {

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
        if (!super.equals(o)) return false;
        SpaceDTO spaceDTO = (SpaceDTO) o;
        return getId() == spaceDTO.getId() && getMaxPeople() == spaceDTO.getMaxPeople() && getPrice() == spaceDTO.getPrice() && isEnabled() == spaceDTO.isEnabled() && Objects.equals(getNameSpace(), spaceDTO.getNameSpace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getNameSpace(), getMaxPeople(), getPrice(), isEnabled());
    }
}
