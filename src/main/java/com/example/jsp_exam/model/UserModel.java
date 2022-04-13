package com.example.jsp_exam.model;

import com.example.jsp_exam.entity.tbUser;
import com.example.jsp_exam.ulti.Config.ConfigSql;
import com.example.jsp_exam.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public tbUser findAccountByUsername(String username) {
        tbUser obj = null;
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            ConfigSql.SELECT_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1, username);
            // PrepareStatement
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String usernameDatabase = resultSet.getString("username");
                String password = resultSet.getString("password");
                obj = new tbUser(usernameDatabase, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
