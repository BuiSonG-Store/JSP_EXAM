package com.example.jsp_exam.model;

import com.example.jsp_exam.entity.Products;
import com.example.jsp_exam.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductModel{
    public List<Products> findAll() {
        List<Products> listObj = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {
            Connection connection = connectionHelper.getConnection();
            String sqlSelect = "select * from product";
            PreparedStatement prepareStatement = connection.prepareStatement(sqlSelect);
            ResultSet rs = prepareStatement.executeQuery(sqlSelect);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");;
                String details = rs.getString("details");
                Products obj = new Products(id, name, price, price, amount,details);
                listObj.add(obj);
            }
        } catch (Exception e) {

        }
        return listObj;
    }

}

