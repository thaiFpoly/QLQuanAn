package com.edusys.dao;

import com.edusys.entity.ChiTietHoaDon;
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
public class ChiTietHoaDonDAO extends QuanAnDAO<ChiTietHoaDon, Integer> {

    @Override
    public void insert(ChiTietHoaDon chiTietHoaDon) {
        String sql = "INSERT INTO ChiTietDonHang (MaDonHang, MaMon, SoLuong, Gia) VALUES (?, ?, ?, ?)";
        XJdbc.update(sql, chiTietHoaDon.getMaDonHang(), chiTietHoaDon.getMaMon(), chiTietHoaDon.getSoLuong(), chiTietHoaDon.getGia());
    }

    @Override
    public void update(ChiTietHoaDon chiTietHoaDon) {
        String sql = "UPDATE ChiTietDonHang SET MaDonHang = ?, MaMon = ?, SoLuong = ?, Gia = ? WHERE MaChiTietDonHang = ?";
        XJdbc.update(sql, chiTietHoaDon.getMaDonHang(), chiTietHoaDon.getMaMon(), chiTietHoaDon.getSoLuong(), chiTietHoaDon.getGia(), chiTietHoaDon.getMaChiTietHoaDon());
    }

    @Override
    public void delete(Integer maChiTietHoaDon) {
        String sql = "DELETE FROM ChiTietDonHang WHERE MaChiTietDonHang = ?";
        XJdbc.update(sql, maChiTietHoaDon);
    }

    @Override
    public ChiTietHoaDon selectById(Integer maChiTietHoaDon) {
        String sql = "SELECT * FROM ChiTietDonHang WHERE MaChiTietDonHang = ?";
        List<ChiTietHoaDon> result = selectBySql(sql, maChiTietHoaDon);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        String sql = "SELECT * FROM ChiTietDonHang";
        return selectBySql(sql);
    }

    @Override
    protected List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
        List<ChiTietHoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    ChiTietHoaDon entity = new ChiTietHoaDon();
                    entity.setMaChiTietHoaDon(rs.getInt("MaChiTietDonHang"));
                    entity.setMaDonHang(rs.getInt("MaDonHang"));
                    entity.setMaMon(rs.getInt("MaMon"));
                    entity.setSoLuong(rs.getInt("SoLuong"));
                    entity.setGia(rs.getDouble("Gia"));

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

    public List<ChiTietHoaDon> selectByDonHang(int maDonHang) {
        String sql = "SELECT * FROM ChiTietDonHang WHERE MaDonHang = ?";
        return selectBySql(sql, maDonHang);
    }
}
