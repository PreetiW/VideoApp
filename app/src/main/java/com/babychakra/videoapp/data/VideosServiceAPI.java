package com.babychakra.videoapp.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Game on 15-09-17.
 */

public interface VideosServiceAPI {

    interface VideosServiceCallback<T> {

        void onLoaded(T videos);
    }

    void getAllVideos(VideosServiceCallback<ArrayList<String>> callback);
}
