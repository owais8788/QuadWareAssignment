/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quad.controller;

import com.quad.dao.Quad_dao;
import com.quad.modal.Quad;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
@WebServlet(name = "Quad_controller", urlPatterns = {"/Quad_controller"})
public class Quad_controller extends HttpServlet {
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getParameter("action");
            System.out.println("form Data: " + action);

            switch (action) {
                case "insert":
                    insertData(request, response);
                    break;
                case "retrive":
                    retriveData(request,response);
                default:
                    break;
            }
        }
    }
    
    
    
    private void insertData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ename = request.getParameter("ename");
        String doj = request.getParameter("doj");
        int yoe = Integer.parseInt(request.getParameter("yoe").toString());
        String designation = request.getParameter("designation");
        
        
        
        Quad quad = new Quad(ename,doj, yoe, designation);

        Quad_dao quad_dao = new Quad_dao();
        String message = quad_dao.insertData(quad);

        response.sendRedirect("index.jsp?message=" + message);
        
    }
    
    private void retriveData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int eid = Integer.parseInt(request.getParameter("eid").toString());
        response.sendRedirect("retrive.jsp?eid=" +eid);
    }
}
