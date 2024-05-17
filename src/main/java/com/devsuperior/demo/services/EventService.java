package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;

import jakarta.validation.Valid;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	@Transactional(readOnly = true)
	public Page<EventDTO> findAll (Pageable pageable){
		Page <Event> result = repository.findAll(pageable);
		return result.map(x -> new EventDTO(x));
	}

	@Transactional
	public EventDTO insert(EventDTO eventDto) {
		Event entity = new Event();
		entity.setCity(new City(eventDto.getCityId(), null));
		entity.setDate(eventDto.getDate());
		entity.setName(eventDto.getName());
		entity.setUrl(eventDto.getUrl());
		entity = repository.save(entity);
		return new EventDTO(entity);
	}

}
