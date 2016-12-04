package com.chikeandroid.retrofittutorial.posts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.chikeandroid.retrofittutorial.R;
import com.chikeandroid.retrofittutorial.data.model.Post;
import com.chikeandroid.retrofittutorial.data.remote.ApiUtils;

import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Chike on 12/4/2016.
 */

public class PostsActivity  extends AppCompatActivity implements PostsContract.View {

    private PostsContract.Presenter mPresenter;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );

        mPresenter = new PostPresenter(this, ApiUtils.getPostService());

    }
    @Override
    public void showPosts(List<Post> posts) {

    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void setPresenter(@NonNull PostsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
