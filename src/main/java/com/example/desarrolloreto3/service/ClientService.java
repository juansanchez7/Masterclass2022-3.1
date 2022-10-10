package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Client;
import com.example.desarrolloreto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client m) {
        if (m.getIdClient() == null) {
            return clientRepository.save(m);
        } else {
            Optional<Client> e = clientRepository.getClient(m.getIdClient());
            if (e.isPresent()) {
                return m;
            }else{
                return clientRepository.save(m);
            }
        }

    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Client> e = clientRepository.getClient(id);
        if (e.isPresent()) {
            clientRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}