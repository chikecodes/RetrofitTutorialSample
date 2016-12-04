package com.chikeandroid.retrofittutorial.data.remote;

import com.chikeandroid.retrofittutorial.data.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chike on 12/3/2016.
 */

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{id}")
    Call<Post> getPostDetail(@Path("id") int id);
}
