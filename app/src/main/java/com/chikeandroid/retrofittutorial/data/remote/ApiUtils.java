package com.chikeandroid.retrofittutorial.data.remote;

/**
 * Created by Chike on 12/4/2016.
 */

public class ApiUtils {

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com";

    public static PostService getPostService() {

        return RetrofitClient.getClient(BASE_URL).create(PostService.class);
    }
}
