package com.example.desarrolloreto3.service;

import com.example.desarrolloreto3.entities.Machine;
import com.example.desarrolloreto3.entities.Score;
import com.example.desarrolloreto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score m) {
        if (m.getIdScore() == null) {
            return scoreRepository.save(m);
        } else {
            Optional<Score> e = scoreRepository.getScore(m.getIdScore());
            if (e.isPresent()) {
                return m;
            }else{
                return scoreRepository.save(m);
            }
        }

    }

    public Score update(Score m) {
        if (m.getIdScore() != null) {
            Optional<Score> e = scoreRepository.getScore(m.getIdScore());
            if (e.isPresent()) {
                if (m.getMessageText() != null) {
                    e.get().setMessageText(m.getMessageText());
                }
                if (m.getStars() != null) {
                    e.get().setStars(m.getStars());
                }
                return scoreRepository.save(e.get());
            }
        }
        return m;
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Score> e = scoreRepository.getScore(id);
        if (e.isPresent()) {
            scoreRepository.delete(e.get());
            flag = true;
        }
        return flag;
    }
}