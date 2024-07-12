/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

/**
 *
 * @author votha
 */
public class BanAn {

    private int maBan;
    private int sucChua;
    private String viTri;
    private int maKhuVuc;

    public BanAn() {
    }
    
    
    
    // Constructor
    public BanAn(int maBan, int sucChua, String viTri, int maKhuVuc) {
        this.maBan = maBan;
        this.sucChua = sucChua;
        this.viTri = viTri;
        this.maKhuVuc = maKhuVuc;
    }

    // Getters and Setters
    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public int getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(int maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }
}
