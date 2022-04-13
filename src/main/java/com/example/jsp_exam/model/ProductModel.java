package com.example.jsp_exam.model;

import com.example.jsp_exam.entity.tbProducts;
import com.example.jsp_exam.ulti.Config.ConfigSql;
import com.example.jsp_exam.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    public List<tbProducts> findAll(){
        List<tbProducts> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = ConfigSql.DATABASE_PRODUCT_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double amount = resultSet.getDouble("amount");
                String details = resultSet.getString("details");
                tbProducts obj = new tbProducts(id, name, price, amount, details);
                listObj.add(obj);
            }
        }catch (Exception e){

        }
        return listObj;
    }

}
