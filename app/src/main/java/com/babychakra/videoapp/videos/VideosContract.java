package com.babychakra.videoapp.videos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Game on 14-09-17.
 */

public interface VideosContract {

    interface View {

        void setProgressIndicator(boolean active);

        void showVideos(ArrayList<String> videos);

    }

    interface UserActionsListener {

        void loadVideos(boolean forceUpdate);

    }


}
