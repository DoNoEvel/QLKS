/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Datphong;
import entity.Khachhang;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamq
 */
public class KhachhangDAO { 
     public void addKhachhang(String maKH, String tenKH, String soDT,String soCCCD, String diaChi) {
        String sql = "INSERT INTO Khachhang (maKH, tenKH, sdtKH, cccd, diachiKH) VALUES (?, ?, ?, ?, ?)";
        XJdbc.update(sql, maKH, tenKH, soDT, soCCCD, diaChi);
    }
    public List<Khachhang> getAllKhachhang() {
        List<Khachhang> list = new ArrayList<>();
        String sql = """
                     select kh.MaKH, kh.TenKH, kh.sdtKH, kh.CCCD, kh.DiachiKH, dp.MaPHG
                     from Khachhang kh
                     inner join Datphong dp
                     ON kh.MaKH = dp.MaKH;""";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Khachhang kh = new Khachhang();
                Datphong phg = new Datphong();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSdtKH(rs.getString("SdtKH"));
                kh.setCccd(rs.getString("Cccd"));
                kh.setDiachiKH(rs.getString("DiachiKH"));
                phg.setMaPHG(rs.getString("MaPHG"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Khachhang getKhachhangByID(String maKH) {
        Khachhang kh = null;
        String sql = "SELECT * FROM Khachhang WHERE MaKH = ?";
        try {
            ResultSet rs = XJdbc.query(sql, maKH);
            if (rs.next()) {
                kh = new Khachhang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSdtKH(rs.getString("SdtKH"));
                kh.setCccd(rs.getString("CCCD"));
                kh.setDiachiKH(rs.getString("DiachiKH"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }
    
    // Tìm kiếm khách hàng theo tên
    public List<Khachhang> searchKhachhangByName(String tenKH) {
        List<Khachhang> list = new ArrayList<>();
        String sql = "SELECT * FROM Khachhang WHERE TenKH LIKE ?";
        try {
            ResultSet rs = XJdbc.query(sql, "%" + tenKH + "%");
            while (rs.next()) {
                Khachhang kh = new Khachhang();
                kh.setMaKH(rs.getString("MaKH"));
                kh.setTenKH(rs.getString("TenKH"));
                kh.setSdtKH(rs.getString("SdtKH"));
                kh.setCccd(rs.getString("Cccd"));
                kh.setDiachiKH(rs.getString("DiachiKH"));
                list.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
