/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
import java.util.Date;

public class Datphong {
    private Date ngDat = new Date();
    private Date ngXuat = new Date();
    private String maDatPHG;   // PK
    private String maPHG;      // FK
    private String maKH;       // FK
    private String maNV;       // FK

    // Constructor
    public Datphong(Date ngDat, Date ngXuat, String maDatPHG, String maPHG, String maKH, String maNV) {
        this.ngDat = ngDat;
        this.ngXuat = ngXuat;
        this.maDatPHG = maDatPHG;
        this.maPHG = maPHG;
        this.maKH = maKH;
        this.maNV = maNV;
    }

    // Getters and Setters
    public Date getNgDat() {
        return ngDat;
    }

    public void setNgDat(Date ngDat) {
        this.ngDat = ngDat;
    }

    public Date getNgXuat() {
        return ngXuat;
    }

    public void setNgXuat(Date ngXuat) {
        this.ngXuat = ngXuat;
    }

    public String getMaDatPHG() {
        return maDatPHG;
    }

    public void setMaDatPHG(String maDatPHG) {
        this.maDatPHG = maDatPHG;
    }

    public String getMaPHG() {
        return maPHG;
    }

    public void setMaPHG(String maPHG) {
        this.maPHG = maPHG;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Datphong() {
    }
    
    
}

