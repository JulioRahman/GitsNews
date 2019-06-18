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
import com.julio.gitsnews.utils.OnRecyclerViewItemClickListener;

import java.lang.ref.WeakReference;
import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {
    private List<BeritaModel> beritaArrayList;
    private Context context;
    private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;

    public BeritaAdapter(Context context, List<BeritaModel> beritaArrayList/*, OnRecyclerViewItemClickListener onRecyclerViewItemClickListener*/) {
        this.beritaArrayList = beritaArrayList;
        this.context = context;
//        this.onRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }

    @Override
    public BeritaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_berita, viewGroup, false);
        return new BeritaAdapter.ViewHolder(view/*, onRecyclerViewItemClickListener*/);
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

    class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/{
        private ImageView ivThumbnail;
        private TextView tvJudul, tvReview, tvAuthor, tvTanggal;
        private CardView cvItemBerita;
        private WeakReference<OnRecyclerViewItemClickListener> listenerRef;

        ViewHolder(View view/*, OnRecyclerViewItemClickListener listener*/) {
            super(view);

//            listenerRef = new WeakReference<>(listener);
            tvJudul = view.findViewById(R.id.tv_judul);
            tvReview = view.findViewById(R.id.tv_review);
            tvAuthor = view.findViewById(R.id.tv_author);
            tvTanggal = view.findViewById(R.id.tv_tanggal);
            cvItemBerita = view.findViewById(R.id.cv_item_berita);
            ivThumbnail = view.findViewById(R.id.iv_thumbnail);

//            cvItemBerita.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View view) {
//            listenerRef.get().onPositionClicked(getAdapterPosition());
//        }
    }
}
