package com.julio.gitsnews.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.julio.gitsnews.R;
import com.julio.gitsnews.adapter.BeritaAdapter;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;
import com.julio.gitsnews.utils.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<BeritaModel> beritaModelList = new ArrayList<>();

    BeritaAdapter beritaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView mainRecycler = findViewById(R.id.activity_main_rv);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);
        beritaAdapter = new BeritaAdapter(beritaModelList, new OnRecyclerViewItemClickListener() {
            @Override
            public void onPositionClicked(int position) {
            }

            @Override
            public void onLongClicked(int position) {

            }
        });

        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Log.d("uwu", "onCreate: "+apiService.toString());
        Call<List<BeritaModel>> call = apiService.getNewsList();
        Log.d("uwu", "onCreate: hilih"+call.toString());
        call.enqueue(new Callback<List<BeritaModel>>() {

            @Override
            public void onResponse(Call<List<BeritaModel>> call, Response<List<BeritaModel>> response) {
                List<BeritaModel> beritaModelList = response.body();

                mainRecycler.setAdapter(beritaAdapter);
                Log.d("wadidaw", "onResponse: "+beritaModelList.get(1).getAuthor());
            }

            @Override
            public void onFailure(Call<List<BeritaModel>> call, Throwable t) {
                Log.d("mamaku", "onFailure: "+t.toString());
            }
        });
    }
}
