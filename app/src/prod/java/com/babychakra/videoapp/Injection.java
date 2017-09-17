package com.babychakra.videoapp;

import com.babychakra.videoapp.data.VideosRepositories;
import com.babychakra.videoapp.data.VideosRepository;
import com.babychakra.videoapp.data.VideosServiceApiImpl;

/**
 * Created by Game on 17-09-17.
 */

public class Injection {

    public static VideosRepository provideVideosRepository() {
        return  VideosRepositories.getInMemoryRepoInstance(new VideosServiceApiImpl());
    }
}
