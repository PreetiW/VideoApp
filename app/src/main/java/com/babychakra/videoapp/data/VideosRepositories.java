package com.babychakra.videoapp.data;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Game on 17-09-17.
 */

public class VideosRepositories {

    private static VideosRepository repository = null;

    public synchronized static VideosRepository getInMemoryRepoInstance(@NonNull VideosServiceAPI videosServiceAPI) {

        checkNotNull(videosServiceAPI);
        if (null == repository) {
            repository = new InMemoryVideosRepository(videosServiceAPI);
    }
        return repository;
    }
}
