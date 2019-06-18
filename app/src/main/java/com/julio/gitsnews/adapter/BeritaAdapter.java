package com.julio.gitsnews.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.julio.gitsnews.R;
import com.julio.gitsnews.model.BeritaModel;
import com.julio.gitsnews.model.ListBeritaModel;
import com.julio.gitsnews.utils.OnRecyclerViewItemClickListener;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private List<BeritaModel> beritaArrayList;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
    public BeritaAdapter(List<BeritaModel> beritaArrayList) {
        this.beritaArrayList = beritaArrayList;
    }
    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_berita, viewGroup, false);
        return new BeritaAdapter.ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(BeritaAdapter.ViewHolder viewHolder, int position) {
        final BeritaModel beritaModel = beritaArrayList.get(position);
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
        if(!TextUtils.isEmpty(beritaModel.getThumbnail())) {
            //belum
        }
    }
    @Override
    public int getItemCount() {
        return beritaArrayList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivThumbnail;
        private TextView tvJudul, tvReview, tvAuthor, tvTanggal;
        private CardView cvItemBerita;
        ViewHolder(View view) {
            super(view);
            tvJudul = view.findViewById(R.id.tv_judul);
            tvReview = view.findViewById(R.id.tv_review);
            tvAuthor = view.findViewById(R.id.tv_author);
            tvTanggal = view.findViewById(R.id.tv_tanggal);
            cvItemBerita = view.findViewById(R.id.cv_item_berita);
            cvItemBerita.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerViewItemClickListener != null) {
                        onRecyclerViewItemClickListener.onItemClick(getAdapterPosition(), view);
                    }
                }
            });
        }
    }
}