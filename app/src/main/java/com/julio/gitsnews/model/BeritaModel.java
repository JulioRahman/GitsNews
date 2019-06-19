package com.julio.gitsnews.model;

import com.google.gson.annotations.SerializedName;

public class BeritaModel {
    @SerializedName("idBerita")
    private String idBerita;

    @SerializedName("kategori")
    private String kategori;

    @SerializedName("judul")
    private String judul;

    @SerializedName("author")
    private String author;

    @SerializedName("tanggal")
    private String tanggal;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("review")
    private String review;

    public String getIdBerita() {
        return idBerita;
    }

    public void setIdBerita(String idBerita) {
        this.idBerita = idBerita;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
