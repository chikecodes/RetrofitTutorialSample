package com.chikeandroid.retrofittutorial.posts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.chikeandroid.retrofittutorial.DividerItemDecoration;
import com.chikeandroid.retrofittutorial.R;
import com.chikeandroid.retrofittutorial.data.model.Post;
import com.chikeandroid.retrofittutorial.data.remote.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Chike on 12/4/2016.
 */

public class PostsActivity  extends AppCompatActivity implements PostsContract.View {

    private PostsContract.Presenter mPresenter;
    private PostsAdapter mAdapter;

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_posts);

        mPresenter = new PostPresenter(this, ApiUtils.getPostService());
        mAdapter = new PostsAdapter(this, new ArrayList<Post>(0), new PostsAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(PostsActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        configureLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    private void configureLayout() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void showPosts(List<Post> posts) {
        mAdapter.updatePosts(posts);
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Error loading posts", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(@NonNull PostsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
