/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author votha
 */
public class LoaiMonAn {

    private int maLoaiMon;
    private String tenLoaiMon;

    public LoaiMonAn() {
    }
    
    
    // Constructor
    public LoaiMonAn(int maLoaiMon, String tenLoaiMon) {
        this.maLoaiMon = maLoaiMon;
        this.tenLoaiMon = tenLoaiMon;
    }

    // Getters and Setters
    public int getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(int maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }

    public String getTenLoaiMon() {
        return tenLoaiMon;
    }

    public void setTenLoaiMon(String tenLoaiMon) {
        this.tenLoaiMon = tenLoaiMon;
    }

}
