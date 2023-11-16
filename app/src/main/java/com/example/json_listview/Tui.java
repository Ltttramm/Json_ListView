package com.example.json_listview;

public class Tui {
    String ten;
    Integer gia;
    String hinh;

    public Tui(String ten, Integer gia, String hinh) {
        this.ten = ten;
        this.gia = gia;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
