package com.foxtrot.tripmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foxtrot.tripmanager.domain.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}
