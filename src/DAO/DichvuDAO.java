/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Dichvu;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.XJdbc;
/**
 *
 * @author phamq
 */
public class DichvuDAO {
    public boolean addDichvu(Dichvu dv) {
        String sql = "INSERT INTO Dichvu(MaDV, TenDV, GiaDV) VALUES (?, ?, ?)";
        try {
            XJdbc.update(sql, dv.getMaDV(),dv.getTenDV(), dv.getGiaDV());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Dichvu> getAllDichvu() {
    List<Dichvu> list = new ArrayList<>();
    String sql = "SELECT * FROM Dichvu";
    try {
        ResultSet rs = XJdbc.query(sql);
        while (rs.next()) {
            Dichvu dv = new Dichvu();
            dv.setGiaDV(rs.getFloat("GiaDV"));
            dv.setMaDV(rs.getString("MaDV"));
            dv.setTenDV(rs.getString("TenDV"));

            list.add(dv);
        }
        rs.getStatement().getConnection().close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}
    public Dichvu getDichvuById(String MaDV) {
    String sql = "SELECT * FROM Dichvu WHERE MaDV = ?";
    try {
        ResultSet rs = XJdbc.query(sql, MaDV);
        if (rs.next()) {
            Dichvu dv = new Dichvu();
            dv.setMaDV(rs.getString("MaDV"));
            dv.setTenDV(rs.getString("TenDV"));
            dv.setGiaDV(rs.getFloat("GiaDV"));
            rs.getStatement().getConnection().close();
            return dv;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
public boolean updateDichvu(Dichvu dv) {
        String sqlUpdateDichvu = "UPDATE Dichvu SET TenDV = ?, GiaDV = ? WHERE MaDV = ?";

    try {
        // Cập nhật thông tin trong bảng Dichvu
            XJdbc.update(sqlUpdateDichvu, dv.getTenDV(), dv.getGiaDV(), dv.getMaDV());
        return true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
public boolean deleteDichvu(String MaDV) {
    String sql = "DELETE FROM Dichvu WHERE MaDV = ?"; // Gọi thủ tục lưu trữ
    try {
        // Thực hiện gọi thủ tục lưu trữ
        XJdbc.update(sql, MaDV);
        return true;
    } catch (Exception e) {
        e.printStackTrace(); // In thông tin lỗi nếu có
    }
    return false; // Trả về false nếu có lỗi xảy ra
}
    public List<Dichvu> getDichvuByMaPHG(String maPHG) {
        List<Dichvu> list = new ArrayList<>();
        String sql = "SELECT dv.TenDV, dv.GiaDV " +
                     "FROM Datphong dp " +
                     "JOIN SudungDV sddv ON dp.MaDatPHG = sddv.MaDatPHG " +
                     "JOIN Dichvu dv ON sddv.MaDV = dv.MaDV " +
                     "WHERE dp.MaPHG = ?";
        
        try {
    ResultSet rs = XJdbc.query(sql, maPHG);
    while (rs.next()) {
        String tenDV = rs.getString("TenDV");
        double giaDV = rs.getDouble("GiaDV");
        Dichvu dv = new Dichvu(tenDV, (float) giaDV);
        list.add(dv);
    }
    rs.getStatement().getConnection().close();
} catch (Exception e) {
    e.printStackTrace();
    // Xử lý ngoại lệ
}
        return list;
    }
}

