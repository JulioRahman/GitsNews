package com.julio.gitsnews.rests;

import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.DetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("read.php")
    //@GET("1bp4r5")
    Call<List<BeritaModel>> getNewsList();

    @GET("read_detail.php")
    //@GET("g388x")
    Call<DetailModel> getNewsDetail(@Query("id") String id);

    @GET("read_by_category.php")
    Call<List<BeritaModel>> getNewsCategory(@Query("kategori") String kategori);
}
