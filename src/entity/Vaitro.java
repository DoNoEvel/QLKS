/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author phamq
 */
public class Vaitro {
    private String maVaitro; // Mã vai trò
    private String tenVaitro; // Tên vai trò

    // Constructor rỗng
    public Vaitro() {
    }

    public Vaitro(String maVaitro, String tenVaitro) {
        this.maVaitro = maVaitro;
        this.tenVaitro = tenVaitro;
    }

    // Getters và Setters
    public String getMaVaitro() {
        return maVaitro;
    }

    public void setMaVaitro(String maVaitro) {
        this.maVaitro = maVaitro;
    }

    public String getTenVaitro() {
        return tenVaitro;
    }

    public void setTenVaitro(String tenVaitro) {
        this.tenVaitro = tenVaitro;
    }
}

