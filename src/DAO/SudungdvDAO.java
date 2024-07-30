/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.SudungDV;
import java.sql.*;
import utils.XJdbc;

/**
 *
 * @author phamq
 */
public class SudungdvDAO {
    public void insertSudungdv(int soLuong, int maDP, String maDV) {
        String sql = "INSERT INTO Sudungdv (soLuong, MaDatPHG, maDV) VALUES (?, ?, ?)";
        XJdbc.update(sql, soLuong, maDP, maDV);
    }
    public boolean updateSudungDV(SudungDV phong) {
    // Câu lệnh SQL để cập nhật thông tin phòng
    String sqlUpdatePhong = "UPDATE SudungDV SET Soluong = ?, MaDatPHG = ? WHERE MaDV = ?";
    
    try {
        // Cập nhật thông tin phòng trong bảng Phong
        XJdbc.update(sqlUpdatePhong, phong.getSoLuong(), phong.getMaDatPHG(), phong.getMaDV());

        return true;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}
    public boolean deleteSudungDV(String MaPHG) {
        String sql = "DELETE FROM SudungDV WHERE MaDV = ?";
        try {
            XJdbc.update(sql, MaPHG);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
