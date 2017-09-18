package com.babychakra.videoapp.videos;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.babychakra.videoapp.Injection;
import com.babychakra.videoapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideosActivity extends YouTubeBaseActivity implements  VideosContract.View, YouTubePlayer.OnInitializedListener {

    private static final String TAG = "VideosActivity+";
    private VideosContract.UserActionsListener videosPresenter;
    @BindView(R.id.youtube_video)
    YouTubePlayerView youtubeVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        videosPresenter = new VideosPresenterImpl(Injection.provideVideosRepository() ,this);
        youtubeVideo.initialize("AIzaSyBJeFxvSLNcD3k8DDuUIYtWAy_QfguGF2w", this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        videosPresenter.loadVideos(false);
    }

    @Override
    public void setProgressIndicator(boolean active) {
        Toast.makeText(this, "Show Progress", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showVideos(ArrayList<String> videosIds) {
        Log.d(TAG, videosIds.toString());
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            youTubePlayer.cueVideo("PbIjuqd4ENY");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
