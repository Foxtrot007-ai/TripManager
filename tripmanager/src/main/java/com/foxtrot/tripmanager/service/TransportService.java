package com.foxtrot.tripmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxtrot.tripmanager.domain.Transport;
import com.foxtrot.tripmanager.repository.TransportRepository;

@Service
public class TransportService {
    @Autowired
    private TransportRepository repo;

    public List<Transport> listAll(){
        return repo.findAll();
    }

    public void save(Transport std){
        repo.save(std);
    }

    public Transport get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
