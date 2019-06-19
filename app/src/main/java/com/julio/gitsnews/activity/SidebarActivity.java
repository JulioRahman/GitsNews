package com.julio.gitsnews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import com.julio.gitsnews.R;
import com.julio.gitsnews.adapter.BeritaAdapter;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.rests.APIClient;
import com.julio.gitsnews.rests.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SidebarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    BeritaAdapter beritaAdapter;
    private String kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if(!TextUtils.isEmpty(getIntent().getStringExtra("kategori"))) {
            kategori = getIntent().getStringExtra("kategori");
        } else {
            kategori = "home";
        }

        final RecyclerView mainRecycler = findViewById(R.id.activity_main_rv);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);


        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
        Log.d("uwu", "onCreate: "+apiService.toString());
        Call<List<BeritaModel>> call = apiService.getNewsList();

        if (kategori.equals("home")) {
            call = apiService.getNewsList();
            Log.d("uwu", "onCreate: hilih"+call.toString());
        } else {
            call = apiService.getNewsCategory(kategori);
            Log.d("uwu", "onCreate: hilih"+call.toString());
        }

        call.enqueue(new Callback<List<BeritaModel>>() {

            @Override
            public void onResponse(Call<List<BeritaModel>> call, Response<List<BeritaModel>> response) {
                List<BeritaModel> beritaModelList = new ArrayList<>();
                beritaModelList.clear();
                beritaModelList = response.body();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent i= new Intent(SidebarActivity.this, SidebarActivity.class);
            i.putExtra("kategori", "home");
            startActivity(i);
        }  else if (id == R.id.nav_about) {
            Intent i= new Intent(SidebarActivity.this, AboutActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_k_teknologi) {
            Intent i= new Intent(SidebarActivity.this, SidebarActivity.class);
            i.putExtra("kategori", "teknologi");
            startActivity(i);
        } else if (id == R.id.nav_k_gadget) {
            Intent i= new Intent(SidebarActivity.this, SidebarActivity.class);
            i.putExtra("kategori", "gadget");
            startActivity(i);
        } else if (id == R.id.nav_k_motivasi) {
            Intent i= new Intent(SidebarActivity.this, SidebarActivity.class);
            i.putExtra("kategori", "motivasi");
            startActivity(i);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
