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
    public List<Dichvu> getAllDichvu() {
        List<Dichvu> list = new ArrayList<>();
        String sql = "SELECT * FROM Dichvu";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Dichvu dv = new Dichvu();
                dv.setMaDV(rs.getString("MaDV"));
                dv.setTenDV(rs.getString("TenDV"));
                dv.setGiaDV(rs.getFloat("GiaDV"));
                list.add(dv);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Dichvu getNhadvienById(String MaDV) {
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
}
