package com.babychakra.videoapp.videos;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class VideosActivity extends YouTubeBaseActivity implements  VideosContract.View {

    private static final String TAG = "VideosActivity";
    private VideosContract.UserActionsListener videosPresenter;

    @BindView(R.id.video_recylerview)
    RecyclerView videRecyclerview;

    private VideosAdapter videosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        init();
    }

    private void init() {
        ButterKnife.bind(this);
        ArrayList<String> videos = new ArrayList<>();
        videos.add("PbIjuqd4ENY");
        videos.add("PbIjuqd4ENY");
        videos.add("PbIjuqd4ENY");
        videos.add("PbIjuqd4ENY");
        videosPresenter = new VideosPresenterImpl(Injection.provideVideosRepository() ,this);

        videosAdapter = new VideosAdapter(videos);
        videRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        videRecyclerview.setAdapter(videosAdapter);

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

}
