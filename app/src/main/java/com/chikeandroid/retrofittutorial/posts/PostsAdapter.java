package com.chikeandroid.retrofittutorial.posts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chikeandroid.retrofittutorial.R;
import com.chikeandroid.retrofittutorial.data.model.Post;

import java.util.List;

/**
 * Created by Chike on 12/4/2016.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Post> mPosts;
    private Context mContext;
    private PostItemListener mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView titleTv;

        PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.tv_title);

            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Post post = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(post.getId());
        }
    }

    public PostsAdapter(Context context, List<Post> posts, PostItemListener itemListener) {
        mPosts = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.post_row_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(postView, this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PostsAdapter.ViewHolder holder, int position) {

        Post post = mPosts.get(position);
        TextView textView = holder.titleTv;
        textView.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    private Post getItem(int adapterPosition) {
        return mPosts.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }

}
