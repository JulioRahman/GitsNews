package com.julio.gitsnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.julio.gitsnews.R;
import com.julio.gitsnews.activity.DetailActivity;
import com.julio.gitsnews.model.BeritaModel;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private final List<BeritaModel> beritaArrayList;
    private final Context context;

    public BeritaAdapter(Context context, List<BeritaModel> beritaArrayList) {
        this.beritaArrayList = beritaArrayList;
        this.context = context;
    }

    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_berita, viewGroup, false);
        return new BeritaAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(BeritaAdapter.ViewHolder viewHolder, int position) {
        final BeritaModel beritaModel = beritaArrayList.get(position);
        Log.d("kenapa susah", "onBindViewHolder: "+beritaModel);
        if(!TextUtils.isEmpty(beritaModel.getJudul())) {
            viewHolder.tvJudul.setText(beritaModel.getJudul());
        }
        if(!TextUtils.isEmpty(beritaModel.getReview())) {
            viewHolder.tvReview.setText(beritaModel.getReview());
        }
        if(!TextUtils.isEmpty(beritaModel.getAuthor())) {
            viewHolder.tvAuthor.setText(beritaModel.getAuthor());
        }
        if(!TextUtils.isEmpty(beritaModel.getTanggal())) {
            viewHolder.tvTanggal.setText(beritaModel.getTanggal());
        }
        if(!TextUtils.isEmpty(beritaModel.getKategori())) {
            viewHolder.tvKategori.setText(beritaModel.getKategori());
        }
        if(!TextUtils.isEmpty(beritaModel.getThumbnail())) {
            Glide.with(context)
                    .load(beritaModel.getThumbnail())
                    .into(viewHolder.ivThumbnail);
        }

        viewHolder.cvItemBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("id", beritaModel.getIdBerita());
                context.startActivity(i);
            }
        });

    }
    @Override
    public int getItemCount() {
        return beritaArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumbnail;
        private final TextView tvJudul;
        private final TextView tvReview;
        private final TextView tvAuthor;
        private final TextView tvTanggal;
        private final TextView tvKategori;
        private final CardView cvItemBerita;

        ViewHolder(View view) {
            super(view);

            tvJudul = view.findViewById(R.id.tv_judul);
            tvReview = view.findViewById(R.id.tv_review);
            tvAuthor = view.findViewById(R.id.tv_author);
            tvTanggal = view.findViewById(R.id.tv_tanggal);
            tvKategori = view.findViewById(R.id.tv_kategori);
            cvItemBerita = view.findViewById(R.id.cv_item_berita);
            ivThumbnail = view.findViewById(R.id.iv_thumbnail);
        }
    }

}
