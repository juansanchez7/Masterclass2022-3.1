package com.example.desarrolloreto3.repository.crudRepository;

import com.example.desarrolloreto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
