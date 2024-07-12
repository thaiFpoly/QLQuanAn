/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.KhachHang;
import com.edusys.utils.XJdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author votha
 */
public class KhachHangDAO extends QuanAnDAO<KhachHang, Integer> {

    @Override
    public void insert(KhachHang khachHang) {
        String sql = "INSERT INTO KhachHang (HoTen, SoDienThoai, Email, DiaChi) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, khachHang.getHoTen(), khachHang.getSoDienThoai(), khachHang.getEmail(), khachHang.getDiaChi());
    }

    @Override
    public void update(KhachHang khachHang) {
        String sql = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, Email = ?, DiaChi = ? WHERE MaKhachHang = ?";
        XJdbc.update(sql, khachHang.getHoTen(), khachHang.getSoDienThoai(), khachHang.getEmail(), khachHang.getDiaChi(), khachHang.getMaKhachHang());
    }

    @Override
    public void delete(Integer maKhachHang) {
        String sql = "DELETE FROM KhachHang WHERE MaKhachHang = ?";
        XJdbc.update(sql, maKhachHang);
    }

    @Override
    public KhachHang selectById(Integer maKhachHang) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang = ?";
        List<KhachHang> result = selectBySql(sql, maKhachHang);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM KhachHang";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhachHang entity = new KhachHang();
                    entity.setMaKhachHang(rs.getInt("MaKhachHang"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setSoDienThoai(rs.getString("SoDienThoai"));
                    entity.setEmail(rs.getString("Email"));
                    entity.setDiaChi(rs.getString("DiaChi"));

                    list.add(entity);
                }
            } finally {
                if (rs != null) {
                    rs.getStatement().getConnection().close();
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<KhachHang> selectByKhachHang(int MaKhachHang) {
        String sql = "SELECT * FROM KhachHang WHERE MaKhachHang=?";
        return this.selectBySql(sql, MaKhachHang);
    }

}
