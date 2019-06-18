package com.julio.gitsnews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.julio.gitsnews.R;
import com.julio.gitsnews.adapter.BeritaAdapter;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    BeritaAdapter beritaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView mainRecycler = findViewById(R.id.activity_main_rv);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);


        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Log.d("uwu", "onCreate: "+apiService.toString());
        Call<List<BeritaModel>> call = apiService.getNewsList();
        Log.d("uwu", "onCreate: hilih"+call.toString());
        call.enqueue(new Callback<List<BeritaModel>>() {

            @Override
            public void onResponse(Call<List<BeritaModel>> call, Response<List<BeritaModel>> response) {
                List<BeritaModel> beritaModelList = response.body();
                beritaAdapter = new BeritaAdapter(getApplicationContext(), beritaModelList);
//                beritaAdapter = new BeritaAdapter(beritaModelList, new OnRecyclerViewItemClickListener() {
//                    @Override
//                    public void onPositionClicked(int position) {
//                        Intent i = new Intent(getApplicationContext(), DetailActivity.class);
//                        i.putExtra("id", String.valueOf(position));
//                        startActivity(i);
//                    }
//
//                    @Override
//                    public void onLongClicked(int position) {
//
//                    }
//                });

                mainRecycler.setAdapter(beritaAdapter);
                Log.d("wadidaw", "onResponse: "+beritaModelList.get(1).getThumbnail());
            }

            @Override
            public void onFailure(Call<List<BeritaModel>> call, Throwable t) {
                Log.d("mamaku", "onFailure: "+t.toString());
            }
        });
    }
}
