package com.t1ne.dao;

import com.t1ne.model.entities.Training;

import java.util.List;

public interface TrainingDAO {
    List<Training> getAll();
    Training get(int id);
    boolean save(Training training);
    boolean delete(int id);
    boolean update(Training training);
}
