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

    public String getIdKategori() {
        return idKategori;
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

    public String getBerita() {
        return berita;
    }

}
