/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.entity;

import java.sql.Date;


/**
 *
 * @author votha
 */
public class HoaDon {

    private int maHoaDon;
    private int maDonHang;
    private Date ngayLap;
    private double tongTien;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, int maDonHang, Date ngayLap, double tongTien) {
        this.maHoaDon = maHoaDon;
        this.maDonHang = maDonHang;
        this.ngayLap = ngayLap;
        this.tongTien = tongTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

  
}
