package com.babychakra.videoapp.data;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Game on 17-09-17.
 */

public class GetPlaylistDataAsyncTask extends AsyncTask<String, Void, ArrayList<String>> {
    private static final String YOUTUBE_PLAYLIST_PART = "snippet";
    private static final String YOUTUBE_PLAYLIST_FIELDS = "pageInfo,nextPageToken,items(id,snippet(resourceId/videoId))";
    private static final String TAG = "GetPlaylistDataAsyncTask" ;
    private static final Long YOUTUBE_PLAYLIST_MAX_RESULTS = 10L;

    private YouTube mYouTubeDataApi;

    public GetPlaylistDataAsyncTask(YouTube api) {
        mYouTubeDataApi = api;
    }

    @Override
    protected ArrayList<String> doInBackground(String... params) {

        final String playlistIds = params[0];

        PlaylistItemListResponse playlistListResponse;
        try {
            playlistListResponse = mYouTubeDataApi.playlistItems()
                    .list(YOUTUBE_PLAYLIST_PART)
                    .setPlaylistId(playlistIds)
                    .setFields(YOUTUBE_PLAYLIST_FIELDS)
                    .setMaxResults(YOUTUBE_PLAYLIST_MAX_RESULTS)
                    .setKey("AIzaSyBJeFxvSLNcD3k8DDuUIYtWAy_QfguGF2w") //Here you will have to provide the keys
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (playlistListResponse == null) {
            Log.e(TAG, "Failed to get playlist");
            return null;
        }

        ArrayList<String> videoIds = new ArrayList();

        // pull out the video id's from the playlist page
        for (PlaylistItem item : playlistListResponse.getItems()) {
            videoIds.add(item.getSnippet().getResourceId().getVideoId());
        }

        return videoIds;
    }
}
