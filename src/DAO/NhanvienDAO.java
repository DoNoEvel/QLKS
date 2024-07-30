package DAO;

import entity.Nhanvien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;

public class NhanvienDAO {

    // Thêm nhân viên mới
    public boolean addNhanvien(Nhanvien nv) {
        String sql = "INSERT INTO Nhanvien(maNV, tenNV, ngsinh, sdtNV, diachiNV, gioitinh, luong, mk, maVaitro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            XJdbc.update(sql, nv.getMaNV(), nv.getTenNV(), new java.sql.Date(nv.getNgsinh().getTime()), nv.getSdtNV(), nv.getDiachiNV(), nv.getGioitinh(), nv.getLuong(), nv.getMk(), nv.getMaVaitro());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//    public List<Object[]> getThongKeLuongNhanVien() {
//        List<Object[]> result = new ArrayList<>();
//        String sql = "EXEC sp_ThongKeNhanVien";
//        try {
//            ResultSet rs = XJdbc.query(sql);
//            while (rs.next()) {
//                int thang = rs.getInt("Thang");
//                int soLuong = rs.getInt("SoLuong");
//                float tongTien = rs.getFloat("TongTien");
//
//                result.add(new Object[]{thang, soLuong, tongTien});
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 
//        return result;
//    }

    // Lấy danh sách tất cả nhân viên
    public List<Nhanvien> getAllNhanvien() {
        List<Nhanvien> list = new ArrayList<>();
        String sql = "SELECT * FROM Nhanvien";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Nhanvien nv = new Nhanvien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTenNV(rs.getString("tenNV"));
                nv.setNgsinh(rs.getDate("ngsinh"));
                nv.setSdtNV(rs.getString("sdtNV"));
                nv.setDiachiNV(rs.getString("diachiNV"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setLuong(rs.getFloat("luong"));
                nv.setMk(rs.getString("mk"));
                nv.setMaVaitro(rs.getString("maVaitro"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Cập nhật thông tin nhân viên
    public boolean updateNhanvien(Nhanvien nv) {
        String sql = "UPDATE Nhanvien SET tenNV = ?, "
                + "ngsinh = ?, "
                + "sdtNV = ?, diachiNV = ?, "
                + "gioitinh = ?, "
                + "luong = ?, "
                + "mk = ?, "
                + "maVaitro = ? WHERE maNV = ?";
        try {
            XJdbc.update(sql, nv.getTenNV(), new java.sql.Date(nv.getNgsinh().getTime()), nv.getSdtNV(), nv.getDiachiNV(), nv.getGioitinh(), nv.getLuong(), nv.getMk(), nv.getMaVaitro(), nv.getMaNV());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

  public boolean deleteNhanvien(String maNV) {
    String sql = "{call [dbo].[XoaNhanVien](?)}"; // Gọi thủ tục lưu trữ
    try {
        // Thực hiện gọi thủ tục lưu trữ
        XJdbc.update(sql, maNV);
        return true;
    } catch (Exception e) {
        e.printStackTrace(); // In thông tin lỗi nếu có
    }
    return false; // Trả về false nếu có lỗi xảy ra
}


    // Tìm nhân viên theo mã
    public Nhanvien getNhanvienById(String maNV) {
        String sql = "SELECT * FROM Nhanvien WHERE maNV = ?";
        try {
            ResultSet rs = XJdbc.query(sql, maNV);
            if (rs.next()) {
                Nhanvien nv = new Nhanvien();
                nv.setMaNV(rs.getString("maNV"));
                nv.setTenNV(rs.getString("tenNV"));
                nv.setNgsinh(rs.getDate("ngsinh"));
                nv.setSdtNV(rs.getString("sdtNV"));
                nv.setDiachiNV(rs.getString("diachiNV"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setLuong(rs.getFloat("luong"));
                nv.setMk(rs.getString("mk"));
                nv.setMaVaitro(rs.getString("maVaitro"));
                rs.getStatement().getConnection().close();
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Nhanvien> searchNhanvienByMaNV(String maNV) {
    List<Nhanvien> list = new ArrayList<>();
    String sql = "SELECT * FROM Nhanvien WHERE MaNV LIKE ?";
    try {
        ResultSet rs = XJdbc.query(sql, "%" + maNV + "%"); // Sử dụng phương thức query từ XJdbc
        while (rs.next()) {
            Nhanvien nv = new Nhanvien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setTenNV(rs.getString("TenNV"));
            nv.setNgsinh(rs.getDate("Ngsinh"));
            nv.setSdtNV(rs.getString("SdtNV"));
            nv.setDiachiNV(rs.getString("DiachiNV"));
            nv.setGioitinh(rs.getString("Gioitinh"));
            nv.setLuong(rs.getFloat("Luong"));
            nv.setMk(rs.getString("Mk"));
            nv.setMaVaitro(rs.getString("MaVaitro"));
            list.add(nv);
        }
        rs.getStatement().getConnection().close(); // Đóng kết nối
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
public List<Nhanvien> searchNhanvienByName(String tenNV) {
    List<Nhanvien> list = new ArrayList<>();
    String sql = "SELECT * FROM Nhanvien WHERE TenNV LIKE ?";
    try {
        ResultSet rs = XJdbc.query(sql, "%" + tenNV + "%"); // Sử dụng phương thức query từ XJdbc
        while (rs.next()) {
            Nhanvien nv = new Nhanvien();
            nv.setMaNV(rs.getString("MaNV"));
            nv.setTenNV(rs.getString("TenNV"));
            nv.setNgsinh(rs.getDate("Ngsinh"));
            nv.setSdtNV(rs.getString("SdtNV"));
            nv.setDiachiNV(rs.getString("DiachiNV"));
            nv.setGioitinh(rs.getString("Gioitinh"));
            nv.setLuong(rs.getFloat("Luong"));
            nv.setMk(rs.getString("Mk"));
            nv.setMaVaitro(rs.getString("MaVaitro"));
            list.add(nv);
        }
        rs.getStatement().getConnection().close(); // Đóng kết nối
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}
