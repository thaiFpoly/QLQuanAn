/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author votha
 */
public class MonAn {

    private int maMon;
    private String tenMon;
    private double gia;
    private String moTa;
    private int maLoaiMon;

    // Constructor
    public MonAn(int maMon, String tenMon, double gia, String moTa, int maLoaiMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.gia = gia;
        this.moTa = moTa;
        this.maLoaiMon = maLoaiMon;
    }

    // Getters and Setters
    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getMaLoaiMon() {
        return maLoaiMon;
    }

    public void setMaLoaiMon(int maLoaiMon) {
        this.maLoaiMon = maLoaiMon;
    }
}
