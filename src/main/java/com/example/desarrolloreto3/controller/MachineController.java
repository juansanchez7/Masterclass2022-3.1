package com.example.desarrolloreto3.controller;

import com.example.desarrolloreto3.entities.Machine;
import com.example.desarrolloreto3.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")
public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Machine> getAll() {
        return machineService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("id") int id) {
        return machineService.getMachine(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine m) {
        return machineService.save(m);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine m) {
        return machineService.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return machineService.delete(id);
    }
}
