package com.edusys.dao;

import com.edusys.entity.DonHang;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonHangDAO extends QuanAnDAO<DonHang, Integer> {

    @Override
    public void insert(DonHang donHang) {
        String sql = "INSERT INTO DonHang (MaKhachHang, MaNhanVien, MaBan, NgayDat, TongTien) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, donHang.getMaKhachHang(), donHang.getMaNhanVien(), donHang.getMaBan(), donHang.getNgayDat(), donHang.getTongTien());
    }

    @Override
    public void update(DonHang donHang) {
        String sql = "UPDATE DonHang SET MaKhachHang = ?, MaNhanVien = ?, MaBan = ?, NgayDat = ?, TongTien = ? WHERE MaDonHang = ?";
        XJdbc.update(sql, donHang.getMaKhachHang(), donHang.getMaNhanVien(), donHang.getMaBan(), donHang.getNgayDat(), donHang.getTongTien(), donHang.getMaDonHang());
    }

    @Override
    public void delete(Integer maDonHang) {
        String sql = "DELETE FROM DonHang WHERE MaDonHang = ?";
        XJdbc.update(sql, maDonHang);
    }

    @Override
    public DonHang selectById(Integer maDonHang) {
        String sql = "SELECT * FROM DonHang WHERE MaDonHang = ?";
        List<DonHang> result = selectBySql(sql, maDonHang);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<DonHang> selectAll() {
        String sql = "SELECT * FROM DonHang";
        return selectBySql(sql);
    }

    @Override
    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    DonHang entity = new DonHang();
                    entity.setMaDonHang(rs.getInt("MaDonHang"));
                    entity.setMaKhachHang(rs.getInt("MaKhachHang"));
                    entity.setMaNhanVien(rs.getInt("MaNhanVien"));
                    entity.setMaBan(rs.getInt("MaBan"));
                    entity.setNgayDat(rs.getDate("NgayDat"));
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

    public List<DonHang> selectByKhachHang(int maKhachHang) {
        String sql = "SELECT * FROM DonHang WHERE MaKhachHang=?";
        return this.selectBySql(sql, maKhachHang);
    }

    public List<DonHang> selectByNhanVien(int maNhanVien) {
        String sql = "SELECT * FROM DonHang WHERE MaNhanVien=?";
        return this.selectBySql(sql, maNhanVien);
    }

    public List<DonHang> selectByBan(int maBan) {
        String sql = "SELECT * FROM DonHang WHERE MaBan=?";
        return this.selectBySql(sql, maBan);
    }
}
