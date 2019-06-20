package com.julio.gitsnews.rests;

import com.google.gson.JsonObject;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.DetailModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("berita/read.php")
    Call<List<BeritaModel>> getNewsList();

    @GET("berita/read_detail.php")
    Call<DetailModel> getNewsDetail(@Query("id") String id);

    @GET("berita/read_by_category.php")
    Call<List<BeritaModel>> getNewsCategory(@Query("kategori") String kategori);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    @POST("feedback/insert.php")
    Call<ResponseBody> postFeedback(@Body JsonObject locationPost);
}
