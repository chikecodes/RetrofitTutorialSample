package com.chikeandroid.retrofittutorial.posts;

import android.support.annotation.NonNull;

import com.chikeandroid.retrofittutorial.data.remote.PostService;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Chike on 12/4/2016.
 */

public class PostPresenter implements PostsContract.Presenter {

    private final PostsContract.View mPostview;
    private final PostService mService;

    public PostPresenter(@NonNull PostsContract.View view, @NonNull PostService service) {
        mPostview = checkNotNull(view);
        mService = checkNotNull(service);
        mPostview.setPresenter(this);
    }

    @Override
    public void loadPosts() {

    }

    @Override
    public void start() {

    }
}
