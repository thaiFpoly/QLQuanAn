package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO extends QuanAnDAO<NhanVien, Integer> {

    @Override
    public void insert(NhanVien nhanVien) {
        String sql = "INSERT INTO NhanVien (HoTen, SoDienThoai, ChucVu, Luong) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, nhanVien.getHoTen(), nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong());
    }

    @Override
    public void update(NhanVien nhanVien) {
        String sql = "UPDATE NhanVien SET HoTen = ?, SoDienThoai = ?, ChucVu = ?, Luong = ? WHERE MaNhanVien = ?";
        XJdbc.update(sql, nhanVien.getHoTen(), nhanVien.getSoDienThoai(), nhanVien.getChucVu(), nhanVien.getLuong(), nhanVien.getMaNhanVien());
    }

    @Override
    public void delete(Integer maNhanVien) {
        String sql = "DELETE FROM NhanVien WHERE MaNhanVien = ?";
        XJdbc.update(sql, maNhanVien);
    }

    @Override
    public NhanVien selectById(Integer maNhanVien) {
        String sql = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
        List<NhanVien> result = selectBySql(sql, maNhanVien);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM NhanVien";
        return selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    NhanVien entity = new NhanVien();
                    entity.setMaNhanVien(rs.getInt("MaNhanVien"));
                    entity.setHoTen(rs.getString("HoTen"));
                    entity.setSoDienThoai(rs.getString("SoDienThoai"));
                    entity.setChucVu(rs.getString("ChucVu"));
                    entity.setLuong(rs.getDouble("Luong"));

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

    public List<NhanVien> selectByChucVu(String chucVu) {
        String sql = "SELECT * FROM NhanVien WHERE ChucVu=?";
        return this.selectBySql(sql, chucVu);
    }

}
