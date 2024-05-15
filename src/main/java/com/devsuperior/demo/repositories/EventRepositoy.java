package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.demo.entities.Event;

@Repository
public interface EventRepositoy  extends JpaRepository <Event, Long> {

}
