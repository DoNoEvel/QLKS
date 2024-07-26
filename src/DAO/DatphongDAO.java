/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Datphong;
import java.util.ArrayList;
import java.util.List;
import utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamq
 */
public class DatphongDAO {
    public List<Datphong> getAllDatphong() {
        List<Datphong> list = new ArrayList<>();
        String sql = "SELECT * FROM Datphong";
        try {
            ResultSet rs = XJdbc.query(sql);
            while (rs.next()) {
                Datphong dp = new Datphong();
                dp.setNgDat(rs.getDate("NgDat"));
                dp.setNgXuat(rs.getDate("NgXuat"));
                dp.setMaDatPHG(rs.getString("MaDatPHG"));
                dp.setMaPHG(rs.getString("MaPHG"));
                dp.setMaKH(rs.getString("MaKH"));
                dp.setMaNV(rs.getString("MaNV"));
                list.add(dp);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
