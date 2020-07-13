package com.t1ne.dao;

import com.t1ne.model.users.Client;

import java.util.List;

public interface ClientDAO {
    List<Client> getAll();
    Client get(int id);
    boolean save(Client client);
    boolean delete(int id);
    boolean update(Client client);
}
