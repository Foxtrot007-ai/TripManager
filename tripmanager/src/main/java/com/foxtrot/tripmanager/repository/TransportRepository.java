package com.foxtrot.tripmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxtrot.tripmanager.domain.Transport;

public interface TransportRepository extends JpaRepository<Transport,Long> {
    
}
