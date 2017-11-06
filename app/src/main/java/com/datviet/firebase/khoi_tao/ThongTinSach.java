package com.datviet.firebase.khoi_tao;

/**
 * Created by wind on 11/5/2017.
 */

public class ThongTinSach {
    public long Barcode;
    public String Tensach;
    public String Loaisach;
    public String Tacgia;
    public String Tinhtrang;
    public int Soluong;
    public String Nhaxuatban;
    public int Namxuatban;
//    String Hinh;

    public ThongTinSach()
    {
        // Rỗng, mặc định của Firebase để tạo vùng nhớ đọc DL về
    }

    public ThongTinSach(long barcode, String tensach, String loaisach, String tacgia, String tinhtrang, int soluong, String nhaxuatban, int namxuatban) {
        Barcode = barcode;
        Tensach = tensach;
        Loaisach = loaisach;
        Tacgia = tacgia;
        Tinhtrang = tinhtrang;
        Soluong = soluong;
        Nhaxuatban = nhaxuatban;
        Namxuatban = namxuatban;
//        Hinh = hinh;
    }
}
