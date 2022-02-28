package com.sbrf.reboot.repository.impl;

import com.sbrf.reboot.dto.Customer;
import com.sbrf.reboot.repository.CustomerRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerH2Repository implements CustomerRepository {

    private final String JDBC_DRIVER = "org.h2.Driver";
    private final String DB_URL = "jdbc:h2:~/my_db";

    private final String USER = "sa";
    private final String PASS = "";

    private final String DB_NAME = "customer";

    private final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS"
            + "CUSTOMERS ("
            + "id NUMERIC auto_increment PRIMARY KEY NOT NULL, "
            + "name VARCHAR(40), "
            + "e_mail VARCHAR(40)"
            + ")";

    private static  final String SELECT_QUERY = "SELECT id, name, e_mail FROM customers";

    private static  final String INSERT_QUERY = "INSERT INTO customers (name, e_mail) VALUES(?, ?)";

    private static  final String DELETE_QUERY = "DELETE FROM customers WHERE id=?";

    Connection conn;

    public CustomerH2Repository() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = new ArrayList<>();
        try (Statement stm = conn.createStatement();
            ResultSet resultSet = stm.executeQuery(SELECT_QUERY)) {
            while (resultSet.next()) {
                customers.add(new Customer(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("e_mail")));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return customers;
    }

    @Override
    public boolean createCustomer(String name, String eMail) {
        try (PreparedStatement pstm = conn.prepareStatement(INSERT_QUERY)) {
            pstm.setString(1, name);
            pstm.setString(2, eMail);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return false;
        }
    }


    @Override
    public boolean deleteCustomer(Long id) {
        try (PreparedStatement pstm = conn.prepareStatement(DELETE_QUERY)) {
            pstm.setLong(1, id);
            int row  = pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return false;
        }
    }
}


