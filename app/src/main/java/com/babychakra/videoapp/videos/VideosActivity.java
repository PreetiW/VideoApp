package com.babychakra.videoapp.videos;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import com.babychakra.videoapp.Injection;
import com.babychakra.videoapp.R;
import com.babychakra.videoapp.data.Video;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.api.services.youtube.YouTube;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideosActivity extends YouTubeBaseActivity implements  VideosContract.View, YouTubePlayer.OnInitializedListener {

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
    public void showVideos(List<Video> videos) {

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            youTubePlayer.cueVideo("tua4SVV-GSE");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
