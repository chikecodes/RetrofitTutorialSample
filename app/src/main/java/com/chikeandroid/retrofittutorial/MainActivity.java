package com.chikeandroid.retrofittutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.chikeandroid.retrofittutorial.adapter.AnswersAdapter;
import com.chikeandroid.retrofittutorial.data.model.Item;
import com.chikeandroid.retrofittutorial.data.model.SOAnswersResponse;
import com.chikeandroid.retrofittutorial.data.remote.ApiUtils;
import com.chikeandroid.retrofittutorial.data.remote.SOService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Chike on 12/11/2016.
 */

public class MainActivity extends AppCompatActivity {

    private AnswersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;

    @Override
    protected void onCreate (Bundle savedInstanceState)  {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_main );

        mService = ApiUtils.getSOService();

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_answers);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {

            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);

        loadAnswers();
    }

    public void loadAnswers() {

        // RxJava Implementation

        /*mService.getAnswers().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SOAnswersResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SOAnswersResponse soAnswersResponse) {
                        mAnswersView.showAnswers(soAnswersResponse.getItems());
                    }
                });*/

        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {

                if(response.isSuccessful()) {
                    mAdapter.updateAnswers(response.body().getItems());
                    Log.d("AnswersPresenter", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
               showErrorMessage();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }


    public void showErrorMessage() {
        Toast.makeText(this, "Error loading posts", Toast.LENGTH_SHORT).show();
    }

}
