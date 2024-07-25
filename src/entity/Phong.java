/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
public class Phong {
    private String maPHG; // Mã phòng
    private String loaiPHG; // Loại phòng
    private float giaPHG; // Giá phòng

    // Constructor
    public Phong(String maPHG, String loaiPHG, float giaPHG) {
        this.maPHG = maPHG;
        this.loaiPHG = loaiPHG;
        this.giaPHG = giaPHG;
    }

    // Getters and Setters
    public String getMaPHG() {
        return maPHG;
    }

    public void setMaPHG(String maPHG) {
        this.maPHG = maPHG;
    }

    public String getLoaiPHG() {
        return loaiPHG;
    }

    public void setLoaiPHG(String loaiPHG) {
        this.loaiPHG = loaiPHG;
    }

    public float getGiaPHG() {
        return giaPHG;
    }

    public void setGiaPHG(float giaPHG) {
        this.giaPHG = giaPHG;
    }

    public Phong() {
    }

    
}

