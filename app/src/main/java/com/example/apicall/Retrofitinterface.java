package com.example.apicall;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Retrofitinterface {

    @POST("pushes")
    Observable<ResponseModel> request(@Body RequestModel requestModel);

    @GET("users/me")
    Observable<GetResponse> response();
}
