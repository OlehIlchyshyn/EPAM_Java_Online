package com.t1ne.dao;

import com.t1ne.model.users.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLClientDAO implements ClientDAO{
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    public MySQLClientDAO() {
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
    public List<Client> getAll() {
        String query = "SELECT * FROM client";
        List<Client> clientList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Client client = new Client(name);
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client get(int id) {
        return null;
    }

    @Override
    public boolean save(Client client) {
        String query = "INSERT INTO client (name) VALUES (?)";
        boolean rowIsInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, client.getName());
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
    public boolean update(Client client) {
        return false;
    }

//    public boolean deleteBook(Client client) throws SQLException {
//        String sql = "DELETE FROM client where client_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, book.getId());
//
//        boolean rowDeleted = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowDeleted;
//    }
//
//    public boolean updateBook(Book book) throws SQLException {
//        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//        sql += " WHERE book_id = ?";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getTitle());
//        statement.setString(2, book.getAuthor());
//        statement.setFloat(3, book.getPrice());
//        statement.setInt(4, book.getId());
//
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowUpdated;
//    }
//
//    public Book getBook(int id) throws SQLException {
//        Book book = null;
//        String sql = "SELECT * FROM book WHERE book_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, id);
//
//        ResultSet resultSet = statement.executeQuery();
//
//        if (resultSet.next()) {
//            String title = resultSet.getString("title");
//            String author = resultSet.getString("author");
//            float price = resultSet.getFloat("price");
//
//            book = new Book(id, title, author, price);
//        }
//
//        resultSet.close();
//        statement.close();
//
//        return book;
//    }
}
