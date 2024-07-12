package com.edusys.dao;

import com.edusys.entity.KhuVuc;
import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhuVucDAO extends QuanAnDAO<KhuVuc, Integer> {

    @Override
    public void insert(KhuVuc khuVuc) {
        String sql = "INSERT INTO KhuVuc (TenKhuVuc) VALUES (?)";
        XJdbc.update(sql, khuVuc.getTenKhuVuc());
    }

    @Override
    public void update(KhuVuc khuVuc) {
        String sql = "UPDATE KhuVuc SET TenKhuVuc = ? WHERE MaKhuVuc = ?";
        XJdbc.update(sql, khuVuc.getTenKhuVuc(), khuVuc.getMaKhuVuc());
    }

    @Override
    public void delete(Integer maKhuVuc) {
        String sql = "DELETE FROM KhuVuc WHERE MaKhuVuc = ?";
        XJdbc.update(sql, maKhuVuc);
    }

    @Override
    public KhuVuc selectById(Integer maKhuVuc) {
        String sql = "SELECT * FROM KhuVuc WHERE MaKhuVuc = ?";
        List<KhuVuc> result = selectBySql(sql, maKhuVuc);
        return result.isEmpty() ? null : result.get(0);
    }

    @Override
    public List<KhuVuc> selectAll() {
        String sql = "SELECT * FROM KhuVuc";
        return selectBySql(sql);
    }

    @Override
    protected List<KhuVuc> selectBySql(String sql, Object... args) {
        List<KhuVuc> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                while (rs.next()) {
                    KhuVuc entity = new KhuVuc();
                    entity.setMaKhuVuc(rs.getInt("MaKhuVuc"));
                    entity.setTenKhuVuc(rs.getString("TenKhuVuc"));

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
