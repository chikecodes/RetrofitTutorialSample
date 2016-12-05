package com.chikeandroid.retrofittutorial.answers;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chikeandroid.retrofittutorial.data.model.SOAnswersResponse;
import com.chikeandroid.retrofittutorial.data.remote.SOService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Chike on 12/4/2016.
 */

public class AnswersPresenter implements AnswersContract.Presenter {

    private final AnswersContract.View mAnswersView;
    private final SOService mService;

    public AnswersPresenter(@NonNull AnswersContract.View view, @NonNull SOService service) {
        mAnswersView = checkNotNull(view);
        mService = checkNotNull(service);
        mAnswersView.setPresenter(this);
    }

    @Override
    public void loadAnswers() {
        mService.getAnswers().enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {

                if(response.isSuccessful()) {
                    mAnswersView.showAnswers(response.body().getItems());
                    Log.d("AnswersPresenter", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {
                mAnswersView.showErrorMessage();
                Log.d("AnswersPresenter", "error loading from API");

            }
        });
    }

    @Override
    public void start() {
        loadAnswers();
    }
}
