/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quad.modal;

/**
 *
 * @author Lenovo
 */
public class Quad {

    private int eid;
    private String ename;
    private String doj;
    private int yoe;
    private String designation;
    
    
    public Quad(String ename, String doj, int yoe, String designation){
        this.ename = ename;
        this.doj = doj;
        this.yoe = yoe;
        this.designation = designation;
    }
    
    public Quad(int eid, String ename, String doj, int yoe, String designation){
        this.eid = eid;
        this.ename = ename;
        this.doj = doj;
        this.yoe = yoe;
        this.designation = designation;
    }
    
    public Quad(){
        
    }

    
    public int getEid(){
        return eid;
    }
    
    public void setEid(int eid){
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDoj() {
        return doj;
    }

    public void setYoe(int yoe) {
        this.yoe = yoe;
    }

    public int getYoe() {
        return yoe;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
       
    
}



