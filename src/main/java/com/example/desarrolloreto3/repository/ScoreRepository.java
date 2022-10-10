package com.example.desarrolloreto3.repository;

import com.example.desarrolloreto3.entities.Score;
import com.example.desarrolloreto3.repository.crudRepository.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

    public Score save(Score m) {
        return scoreCrudRepository.save(m);
    }

    public void delete(Score m) {
        scoreCrudRepository.delete(m);
    }

    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }
}

