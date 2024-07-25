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

public class Nhanvien {
    private String maNV;        // PK
    private String tenNV;
    private Date ngsinh;
    private String sdtNV;
    private String diachiNV;
    private String gioitinh;
    private float luong;
    private String mk;
    private String maVaitro;    // FK

    // Constructor
    public Nhanvien(String maNV, String tenNV, Date ngsinh, String sdtNV, String diachiNV, String gioitinh, float luong, String mk, String maVaitro) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngsinh = ngsinh;
        this.sdtNV = sdtNV;
        this.diachiNV = diachiNV;
        this.gioitinh = gioitinh;
        this.luong = luong;
        this.mk = mk;
        this.maVaitro = maVaitro;
    }

    // Getters and Setters
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgsinh() {
        return ngsinh;
    }

    public void setNgsinh(Date ngsinh) {
        this.ngsinh = ngsinh;
    }

    public String getSdtNV() {
        return sdtNV;
    }

    public void setSdtNV(String sdtNV) {
        this.sdtNV = sdtNV;
    }

    public String getDiachiNV() {
        return diachiNV;
    }

    public void setDiachiNV(String diachiNV) {
        this.diachiNV = diachiNV;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getMaVaitro() {
        return maVaitro;
    }

    public void setMaVaitro(String maVaitro) {
        this.maVaitro = maVaitro;
    }

    public Nhanvien() {
    }
    
}

