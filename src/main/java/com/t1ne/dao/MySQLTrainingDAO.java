package com.t1ne.dao;

import com.t1ne.model.entities.Training;
import com.t1ne.model.users.Client;

import java.sql.*;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class MySQLTrainingDAO implements TrainingDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private MySQLClientDAO clientDAO;
    public MySQLTrainingDAO() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/sports_club?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.jdbcUsername = "root";
        this.jdbcPassword = "root";
        clientDAO = new MySQLClientDAO();
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
    public List<Training> getAll() {
        String query = "SELECT * FROM training";
        List<Training> trainingList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Date trainingDate = resultSet.getDate("date");
                int clientId = resultSet.getInt("client_id");
                Client client = clientDAO.get(clientId);
                trainingList.add(new Training(trainingDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainingList;
    }

    @Override
    public Training get(int id) {
        return null;
    }

    @Override
    public boolean save(Training training) {
        String query = "INSERT INTO training (date, client_id) VALUES (?, ?)";
        boolean rowIsInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(training.getTrainingDate()
                                                        .toInstant()
                                                        .atZone(ZoneId.of("Ukraine/Kyiv"))
                                                        .toLocalDate()));
            preparedStatement.setInt(2, training.getAssignedClient().getClientId());
            rowIsInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowIsInserted;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Training training) {
        return false;
    }
}
