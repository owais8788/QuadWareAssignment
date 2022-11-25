/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quad.dao;

import com.quad.modal.Quad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Quad_dao {

    private static Connection connectDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/employeedetails", "root", "admin");
        return con;
    }

    public String insertData(Quad quad) {
        String message = "error";
        Connection con = null;

        try {
            con = connectDB();
            String sql = "INSERT INTO employees(ename,doj,yoe,designation) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, quad.getEname());
            ps.setString(2, quad.getDoj());
            ps.setInt(3, quad.getYoe());
            ps.setString(4, quad.getDesignation());

            int i = ps.executeUpdate();

            if (i == 1) {
                message = "Data inserted sucessfully";
            } else {
                message = "Data not inserted";
            }

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return message;
    }

    public List<Quad> retrive() throws ClassNotFoundException {
        ArrayList<Quad> records = new ArrayList<>();
        Connection con = null;
        try {
            con = connectDB();
            String sql = "SELECT * FROM employees;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Quad record = new Quad();
                record.setEid(rs.getInt("eid"));
                record.setEname(rs.getString("ename"));
                record.setDoj(rs.getString("doj"));
                record.setYoe(rs.getInt("yoe"));
                record.setDesignation(rs.getString("designation"));

                records.add(record);

            }

        } catch (SQLException e) {
            System.out.println("com.quad.dao.Quad_dao.retrive()" + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e1) {
                    System.out.println("com.quad.dao.Quad_dao.retrive()" + e1.getMessage());
                }
            }

        }
        return records;
    }

}
