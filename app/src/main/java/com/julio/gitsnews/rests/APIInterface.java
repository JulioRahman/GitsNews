package com.julio.gitsnews.rests;

import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.ListBeritaModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("read.php")
    Call<List<BeritaModel>> getNewsList();
}
