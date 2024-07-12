package com.edusys.dao;

import com.edusys.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAO {

    // Thống kê số lượng đơn hàng theo từng tháng
    public List<Object[]> getSoLuongDonHangTheoThang() {
        String sql = "SELECT MONTH(NgayDat) as Thang, COUNT(MaDonHang) as SoLuong FROM DonHang GROUP BY MONTH(NgayDat)";
        return getListOfArray(sql);
    }

    // Thống kê tổng doanh thu theo từng tháng
    public List<Object[]> getDoanhThuTheoThang() {
        String sql = "SELECT MONTH(NgayLap) as Thang, SUM(TongTien) as DoanhThu FROM HoaDon GROUP BY MONTH(NgayLap)";
        return getListOfArray(sql);
    }

    // Thống kê các món ăn bán chạy nhất
    public List<Object[]> getMonAnBanChayNhat() {
        String sql = "SELECT maMon, SUM(SoLuong) as SoLuongBan FROM ChiTietDonHang GROUP BY maMon ORDER BY SoLuongBan DESC";
        return getListOfArray(sql);
    }

    // Thống kê nhân viên có doanh số tốt nhất
    public List<Object[]> getNhanVienCoDoanhSoTotNhat() {
        String sql = "SELECT nv.MaNhanVien, nv.HoTen, SUM(hd.TongTien) as DoanhSo "
                + "FROM HoaDon hd "
                + "JOIN DonHang dh ON hd.MaDonHang = dh.MaDonHang "
                + "JOIN NhanVien nv ON dh.MaNhanVien = nv.MaNhanVien "
                + "GROUP BY nv.MaNhanVien, nv.HoTen "
                + "ORDER BY DoanhSo DESC";
        return getListOfArray(sql);
    }

    // Phương thức chung để thực hiện truy vấn và trả về kết quả dưới dạng danh sách các mảng Object
    private List<Object[]> getListOfArray(String sql, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(sql, args);
                int columnCount = rs.getMetaData().getColumnCount();
                while (rs.next()) {
                    Object[] vals = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        vals[i] = rs.getObject(i + 1);
                    }
                    list.add(vals);
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
