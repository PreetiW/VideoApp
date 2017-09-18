package com.babychakra.videoapp.videos;

import android.support.annotation.NonNull;

import com.babychakra.videoapp.data.VideosRepository;
import com.babychakra.videoapp.util.EspressoIdlingResource;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Game on 14-09-17.
 */

public class VideosPresenterImpl implements VideosContract.UserActionsListener {


    private final VideosRepository mVideosRepository;
    private final VideosContract.View mVideosView;

    public VideosPresenterImpl(@NonNull VideosRepository videosRepository, @NonNull VideosContract.View videosView){
        mVideosRepository = checkNotNull(videosRepository, "Videos repository cannot be null");
        mVideosView = checkNotNull(videosView, "Videos View cannot be null");
    }


    @Override
    public void loadVideos(boolean forceUpdate) {
        mVideosView.setProgressIndicator(true);

        if(forceUpdate){
            mVideosRepository.refreshData();
        }


        // The network request might be handled in a different thread so make sure Espresso knows
        // that the app is busy until the response is handled.
        EspressoIdlingResource.increment(); // App is busy until further notice

        mVideosRepository.getVideos(new VideosRepository.LoadVideosCallback() {

            @Override
            public void onVideosLoaded(ArrayList<String> videos) {

                EspressoIdlingResource.decrement();
                mVideosView.setProgressIndicator(false);
                mVideosView.showVideos(videos);

            }
        });


    }
}
