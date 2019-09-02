package com.example.tambahrizki.heathtracker.Note;

public class DataNote {
    String judulArtikel, deskripsi;

    public DataNote(String judulArtikel, String deskripsi) {
        this.judulArtikel = judulArtikel;
        this.deskripsi = deskripsi;
    }

    public String getJudulArtikel() {
        return judulArtikel;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
}
