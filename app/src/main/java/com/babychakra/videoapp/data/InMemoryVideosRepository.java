package com.babychakra.videoapp.data;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Game on 17-09-17.
 */

public class InMemoryVideosRepository implements VideosRepository {

    private final VideosServiceAPI mVideosServiceAPI;

    /**
     * This method has reduced visibility for testing and is only visible to tests in the same
     * package.
     */
    @VisibleForTesting
    ArrayList<String> mCachedVideoIds;

    public InMemoryVideosRepository(@NonNull VideosServiceAPI videosServiceAPI) {
        mVideosServiceAPI = checkNotNull(videosServiceAPI);
    }

    @Override
    public void getVideos(@NonNull final LoadVideosCallback callback) {
        checkNotNull(callback);

        //Load from API only if Needed.
        if(mCachedVideoIds ==  null) {
            mVideosServiceAPI.getAllVideos(new VideosServiceAPI.VideosServiceCallback<ArrayList<String>>() {
                @Override
                public void onLoaded(ArrayList<String> videos) {
                    mCachedVideoIds = videos;
                    callback.onVideosLoaded(mCachedVideoIds);
                }
            });
        } else {
            callback.onVideosLoaded(mCachedVideoIds);
        }

    }


    @Override
    public void refreshData() {

    }
}
