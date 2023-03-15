package com.sinhvien.myrex;

public class note_tu {
    private int Id;
    private String TenTu;
    private String DinhNghia;
    private byte [] Hinhanh;

    public note_tu(int id, String tenTu, String dinhNghia, byte [] hinhanh)
    {
        Id = id;
        TenTu = tenTu;
        DinhNghia = dinhNghia;
        Hinhanh = hinhanh;
    }
    public note_tu()
    {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDinhNghia() {
        return DinhNghia;
    }

    public void setDinhNghia(String dinhNghia) {
        DinhNghia = dinhNghia;
    }

    public byte[] getHinhanh() {
        return Hinhanh;
    }

    public String getTenTu() {
        return TenTu;
    }

    public void setTenTu(String tenTu) {
        TenTu = tenTu;
    }

    public void setHinhanh(byte[] hinhanh) {
        Hinhanh = hinhanh;
    }

}
