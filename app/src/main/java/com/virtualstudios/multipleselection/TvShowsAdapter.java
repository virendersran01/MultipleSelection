package com.virtualstudios.multipleselection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.ViewHolder> {

    private List<TvShow> tvShows;
    private TvShowsListener tvShowsListener;

    public TvShowsAdapter(List<TvShow> tvShows, TvShowsListener tvShowsListener) {
        this.tvShows = tvShows;
        this.tvShowsListener = tvShowsListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_tv_show, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindTvShow(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public List<TvShow> getSelectedTvShows(){
        List<TvShow> selectedTvShow = new ArrayList<>();
        for (TvShow tvShow : tvShows){
            if (tvShow.isSelected){
                selectedTvShow.add(tvShow);
            }
        }
        return selectedTvShow;
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout layoutTvShow;
        View viewBackground;
        RoundedImageView imageTvShow;
        TextView textName, textCreatedBy, textStory;
        RatingBar ratingBar;
        ImageView imageSelected;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutTvShow = itemView.findViewById(R.id.layoutTvShow);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            imageTvShow = itemView.findViewById(R.id.imageTvShow);
            textName = itemView.findViewById(R.id.textName);
            textCreatedBy = itemView.findViewById(R.id.textCreateBy);
            textStory = itemView.findViewById(R.id.textStory);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imageSelected = itemView.findViewById(R.id.imageSelected);
        }

        void bindTvShow(final TvShow tvShow){
            imageTvShow.setImageResource(tvShow.image);
            textName.setText(tvShow.name);
            textCreatedBy.setText(tvShow.createdBy);
            textStory.setText(tvShow.story);
            ratingBar.setRating(tvShow.rating);

            if (tvShow.isSelected){
                viewBackground.setBackgroundResource(R.drawable.tv_show_selected_background);
                imageSelected.setVisibility(View.VISIBLE);
            }else {
                viewBackground.setBackgroundResource(R.drawable.tv_show_background);
                imageSelected.setVisibility(View.GONE);
            }

            layoutTvShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvShow.isSelected){
                        viewBackground.setBackgroundResource(R.drawable.tv_show_background);
                        imageSelected.setVisibility(View.GONE);
                        tvShow.isSelected = false;
                        if (getSelectedTvShows().size() == 0){
                            tvShowsListener.onTvShowAction(false);
                        }
                    }else {
                        viewBackground.setBackgroundResource(R.drawable.tv_show_selected_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        tvShow.isSelected = true;
                        tvShowsListener.onTvShowAction(true);
                    }
                }
            });
        }
    }
}