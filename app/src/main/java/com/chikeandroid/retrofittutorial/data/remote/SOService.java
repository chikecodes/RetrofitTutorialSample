package com.chikeandroid.retrofittutorial.data.remote;

import com.chikeandroid.retrofittutorial.data.model.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Chike on 12/3/2016.
 */

public interface SOService {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

    /*RxJava
    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Observable<SOAnswersResponse> getAnswers();*/

    /*@GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<List<SOAnswersResponse>> getAnswers(@Query("tagged") String tags);*/

}
