package com.testbank.banco.services;

import com.testbank.banco.controllers.SpaceController;
import com.testbank.banco.data.dto.SpaceDTO;
import com.testbank.banco.exception.RequiredObjectIsNullException;
import com.testbank.banco.exception.ResourceNotFoundException;
import com.testbank.banco.model.Space;
import com.testbank.banco.repository.SpaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.testbank.banco.mapper.ObjectMapper.parseListObjects;
import static com.testbank.banco.mapper.ObjectMapper.parseObject;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@Service
public class SpaceServices {

    private Logger logger = LoggerFactory.getLogger(SpaceServices.class.getName());

    @Autowired
    SpaceRepository repository;

    public List<SpaceDTO> findAll(){
        logger.info("Finding all Spaces" );
        var spaces = parseListObjects(repository.findAll(), SpaceDTO.class);
        spaces.forEach(this::addHateoasLinks);
        return spaces;
    }

    public SpaceDTO findById(Long id){
        logger.info("Finding a specific space" );
        var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No space found for this id"));
        var dto = parseObject(entity, SpaceDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public SpaceDTO create(SpaceDTO spaces){
        if(spaces == null)throw new RequiredObjectIsNullException();
        logger.info("Creating a space" );
        var entity = parseObject(spaces, Space.class);
        var dto = parseObject(repository.save(entity), SpaceDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public SpaceDTO update(SpaceDTO spaces){
        if(spaces == null)throw new RequiredObjectIsNullException();
        logger.info("Updating a space" );
        Space entity = repository.findById(spaces.getId()).orElseThrow(()-> new ResourceNotFoundException("No space found for this id"));
        entity.setNameSpace(spaces.getNameSpace());
        entity.setMaxPeople(spaces.getMaxPeople());
        entity.setPrice(spaces.getPrice());
        var dto = parseObject(repository.save(entity), SpaceDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    public void delete(Long id){
        logger.info("Deleting a space" );
        Space entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No space found for this id"));
        repository.delete(entity);
    }

    @Transactional
    public SpaceDTO disableSpace(Long id){
        logger.info("Disabling a space" );
        repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No space found for this id"));
        repository.disableSpace(id);
        var entity = repository.findById(id).get();
        var dto = parseObject(entity, SpaceDTO.class);
        addHateoasLinks(dto);
        return dto;
    }

    private void addHateoasLinks(SpaceDTO dto) {
        dto.add(linkTo(methodOn(SpaceController.class).findById(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(SpaceController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(SpaceController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(SpaceController.class).update(dto)).withRel("update").withType("PUT"));
        dto.add(linkTo(methodOn(SpaceController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
        dto.add(linkTo(methodOn(SpaceController.class).disableSpace(dto.getId())).withRel("disable").withType("PATCH"));
    }



}
