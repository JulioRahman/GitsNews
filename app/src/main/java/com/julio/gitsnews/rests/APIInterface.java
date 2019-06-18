package com.julio.gitsnews.rests;

import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.DetailModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("read.php")
    Call<List<BeritaModel>> getNewsList();

    @GET("read_detail.php")
    Call<DetailModel> getNewsDetail(@Query("id") String id);
}
