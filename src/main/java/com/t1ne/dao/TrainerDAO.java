package com.t1ne.dao;

import com.t1ne.model.users.Trainer;

import java.util.List;

public interface TrainerDAO {
    List<Trainer> getAll();
    Trainer get(int id);
    boolean save(Trainer client);
    boolean delete(int id);
    boolean update(Trainer client);
}
