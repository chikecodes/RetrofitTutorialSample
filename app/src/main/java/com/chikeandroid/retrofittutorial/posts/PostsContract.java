package com.chikeandroid.retrofittutorial.posts;

import com.chikeandroid.retrofittutorial.BasePresenter;
import com.chikeandroid.retrofittutorial.BaseView;
import com.chikeandroid.retrofittutorial.data.model.Post;

import java.util.List;

/**
 * Created by Chike on 12/4/2016.
 */

public interface PostsContract {

    interface View extends BaseView<Presenter> {
        void showPosts(List<Post> posts);

        void showErrorMessage();
    }

    interface Presenter extends BasePresenter {

        void loadPosts();
    }
}
