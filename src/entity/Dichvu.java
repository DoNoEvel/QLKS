/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
public class Dichvu {
    private String maDV; // Mã dịch vụ
    private String tenDV; // Tên dịch vụ
    private float giaDV; // Giá dịch vụ

    // Constructor
    public Dichvu(String maDV, String tenDV, float giaDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    // Getters and Setters
    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }

    public Dichvu() {
    }

    
}

