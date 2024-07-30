/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Phong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;

/**
 *
 * @author phamq
 */
public class PhongDAO {
    public boolean addPhong(Phong nv) {
        String sql = "INSERT INTO Phong(MaPHG, LoaiPHG, GiaPHG) VALUES (?, ?, ?)";
        try {
            XJdbc.update(sql, nv.getMaPHG(), nv.getLoaiPHG(), nv.getGiaPHG());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<Phong> getAllPhong() {
        List<Phong> list = new ArrayList<>();
        String sql = "SELECT * FROM Phong";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Phong nv = new Phong();
                nv.setMaPHG(rs.getString("MaPHG"));
                nv.setLoaiPHG(rs.getString("LoaiPHG"));
                nv.setGiaPHG(rs.getFloat("GiaPHG"));
                list.add(nv);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Phong getPhongById(String MaPHG) {
        String sql = "SELECT * FROM Phong WHERE MaPHG = ?";
        try {
            ResultSet rs = XJdbc.query(sql, MaPHG);
            if (rs.next()) {
                Phong nv = new Phong();
                nv.setMaPHG(rs.getString("MaPHG"));
                nv.setLoaiPHG(rs.getString("LoaiPHG"));
                nv.setGiaPHG(rs.getFloat("GiaPHG"));
                rs.getStatement().getConnection().close();
                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
public boolean updatePhong(Phong phong) {
    // Câu lệnh SQL để cập nhật thông tin phòng
    String sqlUpdatePhong = "UPDATE Phong SET LoaiPHG = ?, GiaPHG = ? WHERE MaPHG = ?";
    
    try {
        // Cập nhật thông tin phòng trong bảng Phong
        XJdbc.update(sqlUpdatePhong, phong.getLoaiPHG(), phong.getGiaPHG(), phong.getMaPHG());

        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean deletePhong(String MaPHG) {
        String sql = "DELETE FROM Phong WHERE MaPHG = ?";
        try {
            XJdbc.update(sql, MaPHG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
