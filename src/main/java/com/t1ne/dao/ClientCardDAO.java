package com.t1ne.dao;

import com.t1ne.model.entities.ClientCard;

import java.util.List;

public interface ClientCardDAO {
    List<ClientCard> getAll();
    ClientCard get(int id);
    boolean save(ClientCard client);
    boolean delete(int id);
    boolean update(ClientCard client);
}
