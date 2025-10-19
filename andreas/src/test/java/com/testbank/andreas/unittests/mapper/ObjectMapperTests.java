package com.testbank.andreas.unittests.mapper;

import com.testbank.andreas.integrationtest.dto.SpaceDTO;
import com.testbank.andreas.unittests.mapper.mocks.MockSpace;
import com.testbank.banco.model.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.testbank.banco.mapper.ObjectMapper.parseListObjects;
import static com.testbank.banco.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectMapperTests {

    MockSpace inputObject;

    @BeforeEach
    public void setup() {
        inputObject = new MockSpace();
    }

    @Test
    public void parseEntityToDTOTest() {
        SpaceDTO output = parseObject(inputObject.mockEntity(), SpaceDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Space0", output.getNameSpace());
        assertEquals(1, output.getPrice());
        assertEquals(2, output.getMaxPeople());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<SpaceDTO> outputList = parseListObjects(inputObject.mockEntityList(), SpaceDTO.class);
        SpaceDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Space0", outputZero.getNameSpace());
        assertEquals(1, outputZero.getPrice());
        assertEquals(2, outputZero.getMaxPeople());

        SpaceDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Space7", outputSeven.getNameSpace());
        assertEquals(1, outputSeven.getPrice());
        assertEquals(2, outputSeven.getMaxPeople());

        SpaceDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Space12", outputTwelve.getNameSpace());
        assertEquals(1, outputTwelve.getPrice());
        assertEquals(2, outputTwelve.getMaxPeople());
    }

    @Test
    public void parseDTOToEntityTest() {
        Space output = parseObject(inputObject.mockDTO(), Space.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("First Name Space0", output.getNameSpace());
        assertEquals(1, output.getPrice());
        assertEquals(2, output.getMaxPeople());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<Space> outputList = parseListObjects(inputObject.mockDTOList(), Space.class);
        Space outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("First Name Space0", outputZero.getNameSpace());
        assertEquals(1, outputZero.getPrice());
        assertEquals(2, outputZero.getMaxPeople());

        Space outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("First Name Space7", outputSeven.getNameSpace());
        assertEquals(1, outputSeven.getPrice());
        assertEquals(2, outputSeven.getMaxPeople());

        Space outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("First Name Space12", outputTwelve.getNameSpace());
        assertEquals(1, outputTwelve.getPrice());
        assertEquals(2, outputTwelve.getMaxPeople());
    }
}
