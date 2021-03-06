/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.babychakra.videoapp.data;

import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Fake implementation of {@link VideosServiceAPI} to inject a fake service in a hermetic test.
 */
public class FakeVideosServiceApiImpl implements VideosServiceAPI {

    private static List<Video> VIDEOS = Lists.newArrayList(new Video("Title1", "Description1"),
            new Video("Title2", "Description2"));

    @Override
    public void getAllVideos(VideosServiceCallback<List<Video>> callback) {
        callback.onLoaded(VIDEOS);
    }
}
