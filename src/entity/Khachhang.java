/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
public class Khachhang {
    private String maKH;       // PK
    private String tenKH;
    private String sdtKH;
    private String cccd;
    private String diachiKH;

    // Constructor
    public Khachhang(String maKH, String tenKH, String sdtKH, String cccd, String diachiKH) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdtKH = sdtKH;
        this.cccd = cccd;
        this.diachiKH = diachiKH;
    }

    // Getters and Setters
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getDiachiKH() {
        return diachiKH;
    }

    public void setDiachiKH(String diachiKH) {
        this.diachiKH = diachiKH;
    }

    public Khachhang() {
    }
    
    
}
