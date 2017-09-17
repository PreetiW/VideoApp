package com.babychakra.videoapp.data;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Game on 14-09-17.
 */

public interface VideosRepository
{
    interface LoadVideosCallback {

        void onVideosLoaded(List<Video> videos);
    }


    void getVideos(@NonNull LoadVideosCallback callback);

    void refreshData();
}
