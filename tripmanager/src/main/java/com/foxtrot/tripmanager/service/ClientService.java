package com.foxtrot.tripmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foxtrot.tripmanager.domain.Client;
import com.foxtrot.tripmanager.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public List<Client> listAll(){
        return repo.findAll();
    }

    public void save(Client std){
        repo.save(std);
    }

    public Client get(long id){
        return repo.findById(id).get();
    }

    public void delete(long id){
        repo.deleteById(id);
    }
}
