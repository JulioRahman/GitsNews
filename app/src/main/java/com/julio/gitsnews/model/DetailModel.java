package com.julio.gitsnews.model;

import com.google.gson.annotations.SerializedName;

public class DetailModel {
    @SerializedName("idBerita")
    private String idBerita;

    @SerializedName("kategori")
    private String idKategori;

    @SerializedName("judul")
    private String judul;

    @SerializedName("author")
    private String author;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("berita")
    private String berita;

    public String getIdBerita() {
        return idBerita;
    }

    public void setIdBerita(String idBerita) {
        this.idBerita = idBerita;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getBerita() {
        return berita;
    }

    public void setBerita(String berita) {
        this.berita = berita;
    }
}
