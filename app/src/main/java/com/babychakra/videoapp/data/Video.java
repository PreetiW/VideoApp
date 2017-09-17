package com.babychakra.videoapp.data;

import android.support.annotation.Nullable;

import java.util.UUID;

/**
 * Created by Game on 14-09-17.
 */

public class Video {

    @Nullable
    private String videoTitle;
    @Nullable
    private String videoDescription;
    @Nullable
    private String videoURL;

    public Video(@Nullable String title, @Nullable String description) {
        this(title, description, null);
    }

    public Video(@Nullable String title, @Nullable String description, @Nullable String videoUrl) {
        videoTitle = title;
        videoDescription = description;
        videoURL = videoUrl;
    }


    public String getVideoTitle() {
        return videoTitle;
    }


    public String getVideoDescription() {
        return videoDescription;
    }

    public String getVideoURL() {
        return videoURL;
    }

}
