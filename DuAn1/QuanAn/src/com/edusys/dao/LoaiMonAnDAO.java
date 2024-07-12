package com.edusys.dao;

import com.edusys.entity.LoaiMonAn;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiMonAnDAO extends QuanAnDAO<LoaiMonAn, Integer> {

    @Override
    public void insert(LoaiMonAn loaiMonAn) {
        String sql = "INSERT INTO LoaiMonAn (TenLoaiMon) VALUES (?)";
        XJdbc.update(sql, loaiMonAn.getTenLoaiMon());
    }

    @Override
    public void update(LoaiMonAn loaiMonAn) {
        String sql = "UPDATE LoaiMonAn SET TenLoaiMon = ? WHERE MaLoaiMon = ?";
        XJdbc.update(sql, loaiMonAn.getTenLoaiMon(), loaiMonAn.getMaLoaiMon());
    }

    @Override
    public void delete(Integer maLoaiMon) {
        String sql = "DELETE FROM LoaiMonAn WHERE MaLoaiMon = ?";
        XJdbc.update(sql, maLoaiMon);
    }

    @Override
    public LoaiMonAn selectById(Integer maLoaiMon) {
        String sql = "SELECT * FROM LoaiMonAn WHERE MaLoaiMon = ?";
        List<LoaiMonAn> result = selectBySql(sql, maLoaiMon);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<LoaiMonAn> selectAll() {
        String sql = "SELECT * FROM LoaiMonAn";
        return selectBySql(sql);
    }

    @Override
    protected List<LoaiMonAn> selectBySql(String sql, Object... args) {
        List<LoaiMonAn> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    LoaiMonAn entity = new LoaiMonAn();
                    entity.setMaLoaiMon(rs.getInt("MaLoaiMon"));
                    entity.setTenLoaiMon(rs.getString("TenLoaiMon"));

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
}
