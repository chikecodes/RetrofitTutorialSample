package com.chikeandroid.retrofittutorial.posts;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chikeandroid.retrofittutorial.data.model.Post;
import com.chikeandroid.retrofittutorial.data.remote.PostService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        mService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(response.isSuccessful()) {
                    mPostview.showPosts(response.body());
                    Log.d("PostPresenter", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                mPostview.showErrorMessage();
                Log.d("PostPresenter", "error loading from API");

            }
        });
    }

    @Override
    public void start() {
        loadPosts();
    }
}
