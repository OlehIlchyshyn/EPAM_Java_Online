package com.t1ne.dao;

import com.t1ne.model.entities.ClientCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MySQLClientCardDAO implements ClientCardDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    public MySQLClientCardDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = "jdbc:mysql://localhost:3306/sports_club?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.jdbcUsername = "root";
        this.jdbcPassword = "root";
    }

    private Connection getConnection() {
        Connection jdbcConnection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return jdbcConnection;
    }

    @Override
    public List<ClientCard> getAll() {
        return null;
    }

    @Override
    public ClientCard get(int id) {
        return null;
    }

    @Override
    public boolean save(ClientCard client) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(ClientCard client) {
        return false;
    }
}
