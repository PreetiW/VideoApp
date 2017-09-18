package com.babychakra.videoapp.videos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.babychakra.videoapp.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by Game on 18-09-17.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {

    private ArrayList<String> videoIdsList;

    public VideosAdapter(ArrayList<String> videoIds){
        videoIdsList = videoIds;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.video_list_item, parent, false);

        return new ViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return videoIdsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private YouTubePlayerView youtubeVideo;

        public ViewHolder(View itemView) {
            super(itemView);
            youtubeVideo = (YouTubePlayerView) itemView.findViewById(R.id.youtube_video);
        }

    }
}
