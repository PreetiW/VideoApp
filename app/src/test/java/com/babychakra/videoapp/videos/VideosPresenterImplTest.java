package com.babychakra.videoapp.videos;

import com.babychakra.videoapp.data.Video;
import com.babychakra.videoapp.data.VideosRepository;
import com.google.common.collect.Lists;


import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * Created by Game on 14-09-17.
 */

public class VideosPresenterImplTest {

    private static List<Video> VIDEOS = Lists.newArrayList(new Video("Title1", "Description1"),
            new Video("Title2", "Description2"));

    @Mock
    private VideosRepository mVideosRepository;

    @Mock
    private VideosContract.View mVideosView;

    /**
     * {@link ArgumentCaptor} is a powerful Mockito API to capture argument values and use them to
     * perform further actions or assertions on them.
     */
    @Captor
    private ArgumentCaptor<VideosRepository.LoadVideosCallback> mLoadVideosCallbackCaptor;

    private VideosPresenterImpl mVideosPresenter;

    @Before
    public void setupNotesPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this);

        // Get a reference to the class under test
        mVideosPresenter = new VideosPresenterImpl(mVideosRepository, mVideosView);
    }

    @Test
    public void loadVideosFromRepositoryAndLoadIntoView() {

//        // Given an initialized VideosPresenterImpl with initialized Videos
//        // When loading of Videos is requested
        mVideosPresenter.loadVideos(true);
//
//        // Callback is captured and invoked with stubbed videos
        verify(mVideosRepository).getVideos(mLoadVideosCallbackCaptor.capture());
        mLoadVideosCallbackCaptor.getValue().onVideosLoaded(VIDEOS);
//
//        // Then progress indicator is hidden and notes are shown in UI
        verify(mVideosView).setProgressIndicator(false);
        verify(mVideosView).showVideos(VIDEOS);
    }
}
