package com.babychakra.videoapp.videos;

import com.babychakra.videoapp.data.Video;

import java.util.List;

/**
 * Created by Game on 14-09-17.
 */

public interface VideosContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showVideos(List<Video> videos);

    }

    interface UserActionsListener {

        void loadVideos(boolean forceUpdate);

    }


}
