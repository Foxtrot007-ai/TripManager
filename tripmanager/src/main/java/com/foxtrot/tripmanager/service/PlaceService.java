package com.foxtrot.tripmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxtrot.tripmanager.domain.Place;
import com.foxtrot.tripmanager.repository.PlaceRepository;

@Service
public class PlaceService {
    @Autowired
    private PlaceRepository repo;

    public List<Place> listAll(){
        return repo.findAll();
    }

    public void save(Place std){
        repo.save(std);
    }

    public Place get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}