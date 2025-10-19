package com.testbank.andreas.unittests.mapper.mocks;

import com.testbank.andreas.integrationtest.dto.SpaceDTO;
import com.testbank.banco.model.Space;

import java.util.ArrayList;
import java.util.List;

public class MockSpace {

    public Space mockEntity() {
        return mockEntity(0);
    }

    public SpaceDTO mockDTO() {
        return mockDTO(0);
    }

    public List<Space> mockEntityList(){
        List<Space> spaces = new ArrayList<Space>();
        for (int i = 0; i < 14; i ++){
            spaces.add(mockEntity(i));
        }
        return spaces;
    }

    public List<SpaceDTO> mockDTOList(){
        List<SpaceDTO> spaces = new ArrayList<>();
        for (int i = 0; i < 14; i ++){
            spaces.add(mockDTO(i));
        }
        return spaces;
    }

    public Space mockEntity(Integer number){
        Space space = new Space();
        space.setNameSpace("First Name Space" + number);
        space.setPrice(1 + number);
        space.setMaxPeople(2 + number);
        space.setId(number.longValue());
        return space;
    }

    public SpaceDTO mockDTO(Integer number){
        SpaceDTO space = new SpaceDTO();
        space.setNameSpace("First Name Space" + number);
        space.setPrice(1 + number);
        space.setMaxPeople(2 + number);
        space.setId(number.longValue());
        return space;
    }




}
