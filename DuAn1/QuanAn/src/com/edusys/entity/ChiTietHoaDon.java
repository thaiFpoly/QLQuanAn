package com.edusys.entity;

/**
 *
 * @author votha
 */
public class ChiTietHoaDon {

    private int maChiTietHoaDon;
    private int maDonHang;
    private int maMon;
    private int soLuong;
    private double gia;

    // Constructors
    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int maChiTietHoaDon, int maDonHang, int maMon, int soLuong, double gia) {
        this.maChiTietHoaDon = maChiTietHoaDon;
        this.maDonHang = maDonHang;
        this.maMon = maMon;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    // Getters and Setters
    public int getMaChiTietHoaDon() {
        return maChiTietHoaDon;
    }

    public void setMaChiTietHoaDon(int maChiTietHoaDon) {
        this.maChiTietHoaDon = maChiTietHoaDon;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "ChiTietHoaDon{" +
                "maChiTietHoaDon=" + maChiTietHoaDon +
                ", maDonHang=" + maDonHang +
                ", maMon=" + maMon +
                ", soLuong=" + soLuong +
                ", gia=" + gia +
                '}';
    }
}
