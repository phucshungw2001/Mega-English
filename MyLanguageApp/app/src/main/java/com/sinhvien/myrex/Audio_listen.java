package com.sinhvien.myrex;

public class Audio_listen {

    private  String Title;
    private int File;

    public Audio_listen(String titel, int file) {
        Title = titel;
        File  = file;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getFile() {
        return File;
    }

    public void setFile(int file) {
        File = file;
    }
}
