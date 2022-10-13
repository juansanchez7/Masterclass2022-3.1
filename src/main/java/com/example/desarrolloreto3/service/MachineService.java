package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Machine;
import com.example.desarrolloreto3.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getMachine(int id) {
        return machineRepository.getMachine(id);
    }

    public Machine save(Machine m) {
        if (m.getId() == null) {
            return machineRepository.save(m);
        } else {
            Optional<Machine> e = machineRepository.getMachine(m.getId());
            if (e.isPresent()) {
                return m;
            }else{
                return machineRepository.save(m);
            }
        }

    }


    public Machine update(Machine m) {
        if (m.getId() != null) {
            Optional<Machine> e = machineRepository.getMachine(m.getId());
            if (e.isPresent()) {
                if (m.getName() != null) {
                    e.get().setName(m.getName());
                }
                if (m.getBrand() != null) {
                    e.get().setBrand(m.getBrand());
                }
                if (m.getYear() != null) {
                    e.get().setYear(m.getYear());
                }
                if (m.getDescription() != null) {
                    e.get().setDescription(m.getDescription());
                }
                return machineRepository.save(e.get());
            }
        }
        return m;
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Machine> e = machineRepository.getMachine(id);
        if (e.isPresent()) {
            machineRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}