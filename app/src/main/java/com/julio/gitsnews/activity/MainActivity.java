package com.julio.gitsnews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.julio.gitsnews.R;
import com.julio.gitsnews.adapter.BeritaAdapter;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.ListBeritaModel;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView mainRecycler = findViewById(R.id.activity_main_rv);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);

        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);

        Call<ListBeritaModel> call = apiService.getNewsList();

        call.enqueue(new Callback<ListBeritaModel>() {
            @Override
            public void onResponse(Call<ListBeritaModel> call, Response<ListBeritaModel> response) {
                List<BeritaModel> beritaList = response.body().getListBeritaModels();
                if(beritaList.size()>0) {
                    final BeritaAdapter beritaAdapter = new BeritaAdapter(beritaList);
                    //beritaAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                    mainRecycler.setAdapter(beritaAdapter);
                }
            }

            @Override
            public void onFailure(Call<ListBeritaModel> call, Throwable t) {
                Log.e("out", t.toString());
            }
        });
    }
}
