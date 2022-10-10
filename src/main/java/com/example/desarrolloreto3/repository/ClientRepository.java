package com.example.desarrolloreto3.repository;

import com.example.desarrolloreto3.entities.Client;
import com.example.desarrolloreto3.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientRepository;

    public List<Client>getAll(){
        return (List<Client>) clientRepository.findAll();
    }

    public Client save(Client m){
        return clientRepository.save(m);
    }

    public void delete(Client m){
        clientRepository.delete(m);
    }

    public Optional<Client> getClient(int id){
        return clientRepository.findById(id);
    }

}