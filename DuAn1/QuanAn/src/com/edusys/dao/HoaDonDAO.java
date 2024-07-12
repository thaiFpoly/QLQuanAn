package com.edusys.dao;

import com.edusys.entity.HoaDon;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonDAO extends QuanAnDAO<HoaDon, Integer> {

    @Override
    public void insert(HoaDon hoaDon) {
        String sql = "INSERT INTO HoaDon (MaDonHang, NgayLap, TongTien) VALUES (?, ?, ?)";
        XJdbc.update(sql, hoaDon.getMaDonHang(), hoaDon.getNgayLap(), hoaDon.getTongTien());
    }

    @Override
    public void update(HoaDon hoaDon) {
        String sql = "UPDATE HoaDon SET MaDonHang = ?, NgayLap = ?, TongTien = ? WHERE MaHoaDon = ?";
        XJdbc.update(sql, hoaDon.getMaDonHang(), hoaDon.getNgayLap(), hoaDon.getTongTien(), hoaDon.getMaHoaDon());
    }

    @Override
    public void delete(Integer maHoaDon) {
        String sql = "DELETE FROM HoaDon WHERE MaHoaDon = ?";
        XJdbc.update(sql, maHoaDon);
    }

    @Override
    public HoaDon selectById(Integer maHoaDon) {
        String sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
        List<HoaDon> result = selectBySql(sql, maHoaDon);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<HoaDon> selectAll() {
        String sql = "SELECT * FROM HoaDon";
        return selectBySql(sql);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    HoaDon entity = new HoaDon();
                    entity.setMaHoaDon(rs.getInt("MaHoaDon"));
                    entity.setMaDonHang(rs.getInt("MaDonHang"));
                    entity.setNgayLap(rs.getDate("NgayLap"));
                    entity.setTongTien(rs.getDouble("TongTien"));

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

    public List<HoaDon> selectByMaDonHang(int maDonHang) {
        String sql = "SELECT * FROM HoaDon WHERE MaDonHang=?";
        return this.selectBySql(sql, maDonHang);
    }

}
