package com.foxtrot.tripmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxtrot.tripmanager.domain.Place;

public interface PlaceRepository extends JpaRepository<Place,Long> {
    
}