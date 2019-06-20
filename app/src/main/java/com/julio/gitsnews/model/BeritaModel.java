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

    public String getKategori() {
        return kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String getAuthor() {
        return author;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getReview() {
        return review;
    }

}
