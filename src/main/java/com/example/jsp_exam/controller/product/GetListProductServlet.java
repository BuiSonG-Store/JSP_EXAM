package com.example.jsp_exam.controller.product;

import com.example.jsp_exam.entity.tbProducts;
import com.example.jsp_exam.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = new ProductModel();
        List<tbProducts> listObj = model.findAll();
        req.setAttribute("listObj",listObj);
        req.getRequestDispatcher("/products/ListProduct.jsp").forward(req,resp);
    }
}
