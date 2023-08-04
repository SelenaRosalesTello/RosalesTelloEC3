package com.rosales.ec03.fragmets;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rosales.ec03.databinding.ItemShowResumeBinding;
import com.rosales.ec03.model.Entradas;
import com.rosales.ec03.model.Platos;
import com.rosales.ec03.model.Principal;

import java.util.List;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class RVResumeAdapter extends RecyclerView.Adapter <RVResumeAdapter.ResumeVH>{
    private List<Principal> shows ;

    public RVResumeAdapter(List<Principal> shows) {
        this.shows = shows;
    }

    @NonNull
    @Override
    public ResumeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemShowResumeBinding binding = ItemShowResumeBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new ResumeVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeVH holder, int position) {
        holder.bind(shows.get(position));

    }

    @Override
    public int getItemCount() {
        return shows.size();
    }

    class ResumeVH extends RecyclerView.ViewHolder{

        private ItemShowResumeBinding binding;

        public ResumeVH(ItemShowResumeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Principal show) {
            if(show instanceof Entradas){
                binding.txtSeason.setVisibility(View.GONE);
            }else if (show instanceof Platos){
                binding.txtSeason.setVisibility(View.VISIBLE);
                binding.txtSeason.setText("Season "+ ((Platos)show).getSeason());
            }
            binding.txtName.setText(show.getName());
            ImageLoader imageLoader = Coil.imageLoader(binding.getRoot().getContext());
            ImageRequest request = new ImageRequest.Builder(binding.getRoot().getContext())
                    .data(show.getImgUrl())
                    .crossfade(true)
                    .target(binding.imgShow)
                    .build();
            imageLoader.enqueue(request);

        }
    }
}
