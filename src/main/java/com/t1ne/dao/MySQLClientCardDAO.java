package com.t1ne.dao;

import com.t1ne.model.entities.ClientCard;
import com.t1ne.model.enums.ABONEMENT_TYPE;
import com.t1ne.model.users.Client;

import java.sql.*;
import java.util.ArrayList;
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
        String query = "SELECT * FROM client_card";
        List<ClientCard> clientCardListList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("client_card_id");
                String abonementType = resultSet.getString("abonement_type");
                Date dueDate = resultSet.getDate("due_date");
                ClientCard clientCard = new ClientCard();
                clientCard.setCardId(id);
                switch (abonementType) {
                    case "Monthly":
                        clientCard.setAbonementType(ABONEMENT_TYPE.MONTHLY);
                    case "Half-year":
                        clientCard.setAbonementType(ABONEMENT_TYPE.HALF_YEAR);
                    case "Yearly":
                        clientCard.setAbonementType(ABONEMENT_TYPE.YEARLY);
                }
                clientCard.setDueDate(dueDate);
                clientCardListList.add(clientCard);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientCardListList;
    }

    @Override
    public ClientCard get(int id) {
        String query = "SELECT * FROM client_card WHERE client_card_id = " + id;
        ClientCard clientCard = new ClientCard();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            String abonementType = resultSet.getString("abonement_type");
            Date dueDate = resultSet.getDate("due_date");
            clientCard.setCardId(id);
            switch (abonementType) {
                case "Monthly":
                    clientCard.setAbonementType(ABONEMENT_TYPE.MONTHLY);
                case "Half-year":
                    clientCard.setAbonementType(ABONEMENT_TYPE.HALF_YEAR);
                case "Yearly":
                    clientCard.setAbonementType(ABONEMENT_TYPE.YEARLY);
            }
            clientCard.setDueDate(dueDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientCard;
    }

    @Override
    public boolean save(ClientCard clientCard) {
        String query = "INSERT INTO client_card (client_card_id, abonement_type, due_date) VALUES (?, ?, ?)";
        boolean rowIsInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, clientCard.getAbonementType().toString());
            preparedStatement.setDate(2, new java.sql.Date(clientCard.getDueDate().getTime()));
            rowIsInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowIsInserted;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM client_card WHERE client_card_id = " + id;
        boolean rowIsDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            rowIsDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowIsDeleted;
    }

    @Override
    public boolean update(ClientCard clientCard) {
        String query = "UPDATE client_card SET abonement_type = ?, due_date = ? WHERE client_card_id = ?";
        boolean rowIsUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, clientCard.getAbonementType().toString());
            preparedStatement.setDate(2, new java.sql.Date(clientCard.getDueDate().getTime()));
            preparedStatement.setInt(3, clientCard.getCardId());
            rowIsUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowIsUpdated;
    }
}
