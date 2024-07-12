package com.edusys.dao;

import com.edusys.entity.BanAn;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BanAnDAO extends QuanAnDAO<BanAn, Integer> {

    @Override
    public void insert(BanAn banAn) {
        String sql = "INSERT INTO BanAn (SucChua, ViTri, MaKhuVuc) VALUES (?, ?, ?)";
        XJdbc.update(sql, banAn.getSucChua(), banAn.getViTri(), banAn.getMaKhuVuc());
    }

    @Override
    public void update(BanAn banAn) {
        String sql = "UPDATE BanAn SET SucChua = ?, ViTri = ?, MaKhuVuc = ? WHERE MaBan = ?";
        XJdbc.update(sql, banAn.getSucChua(), banAn.getViTri(), banAn.getMaKhuVuc(), banAn.getMaBan());
    }

    @Override
    public void delete(Integer maBan) {
        String sql = "DELETE FROM BanAn WHERE MaBan = ?";
        XJdbc.update(sql, maBan);
    }

    @Override
    public BanAn selectById(Integer maBan) {
        String sql = "SELECT * FROM BanAn WHERE MaBan = ?";
        List<BanAn> result = selectBySql(sql, maBan);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<BanAn> selectAll() {
        String sql = "SELECT * FROM BanAn";
        return selectBySql(sql);
    }

    @Override
    protected List<BanAn> selectBySql(String sql, Object... args) {
        List<BanAn> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    BanAn entity = new BanAn();
                    entity.setMaBan(rs.getInt("MaBan"));
                    entity.setSucChua(rs.getInt("SucChua"));
                    entity.setViTri(rs.getString("ViTri"));
                    entity.setMaKhuVuc(rs.getInt("MaKhuVuc"));

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

    public List<BanAn> selectByKhuVuc(int maKhuVuc) {
        String sql = "SELECT * FROM BanAn WHERE MaKhuVuc=?";
        return this.selectBySql(sql, maKhuVuc);
    }

}
