package com.julio.gitsnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.julio.gitsnews.R;
import com.julio.gitsnews.model.DetailModel;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private String id;
    private ImageView ivThumbnailD;
    private TextView tvJudulD, tvAuthorD, tvTanggalD, tvBeritaD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getStringExtra("id");

        ivThumbnailD = findViewById(R.id.iv_thumbnail_d);
        tvJudulD = findViewById(R.id.tv_judul_d);
        tvAuthorD = findViewById(R.id.tv_author_d);
        tvTanggalD = findViewById(R.id.tv_tanggal_d);
        tvBeritaD = findViewById(R.id.tv_berita_d);

        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Call<DetailModel> call = apiService.getNewsDetail(id);
        call.enqueue(new Callback<DetailModel>() {

            @Override
            public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {
                DetailModel detailModel = response.body();

                Glide.with(getApplicationContext())
                        .load(detailModel.getThumbnail())
                        .into(ivThumbnailD);
                tvJudulD.setText(detailModel.getJudul());
                tvAuthorD.setText(detailModel.getAuthor());
                tvTanggalD.setText(detailModel.getTanggal());
                tvBeritaD.setText(detailModel.getBerita());
            }

            @Override
            public void onFailure(Call<DetailModel> call, Throwable t) {
                Log.d("mamaku", "onFailure: "+t.toString());
            }
        });
    }
}
