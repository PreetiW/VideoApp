package com.babychakra.videoapp.data;

import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistListResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Game on 17-09-17.
 */

public class VideosServiceApiImpl implements VideosServiceAPI {

    private static final String TAG = "VideosServiceAPI" ;
    private YouTube mYoutubeDataApi;
    private final GsonFactory mJsonFactory = new GsonFactory();
    private final HttpTransport mTransport = AndroidHttp.newCompatibleTransport();

    @Override
    public void getAllVideos(final VideosServiceCallback<ArrayList<String>> callback) {

        mYoutubeDataApi = new YouTube.Builder(mTransport, mJsonFactory, null)
                .setApplicationName("Youtubeapp")
                .build();

        String[] ids = {"PLRBp0Fe2GpgnZOm5rCopMAOYhZCPoUyO5"};

        new GetPlaylistDataAsyncTask(mYoutubeDataApi) {

            @Override
            protected void onPreExecute() {
               Log.d(TAG, "OnPreExexure");
            }

            @Override
            protected void onPostExecute(ArrayList<String> videoIds) {
                super.onPostExecute(videoIds);
                callback.onLoaded(videoIds);

            }
        }.execute(ids);

    }
}
