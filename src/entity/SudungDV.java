/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
public class SudungDV {
    private int soLuong; // Số lượng
    private String maDatPHG; // Mã đặt phòng
    private String maDV; // Mã dịch vụ

    // Constructor rỗng
    public SudungDV() {
    }

    public SudungDV(int soLuong, String maDatPHG, String maDV) {
        this.soLuong = soLuong;
        this.maDatPHG = maDatPHG;
        this.maDV = maDV;
    }
    
    

    // Getters và Setters
    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaDatPHG() {
        return maDatPHG;
    }

    public void setMaDatPHG(String maDatPHG) {
        this.maDatPHG = maDatPHG;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }
}

