package com.example.largefilessendinglibrary.Api;

import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Streaming;

public interface Api {
    @Streaming
    @Multipart
    @POST("saveAmiImage")
    Call<JsonObject> uploadImage(@Part MultipartBody.Part image,
                                 @Part("empId") RequestBody empId,
                                 @Part("taskId") RequestBody taskId,
                                 @Part("subTaskId") RequestBody subTaskId,
                                 @Part("surveyId") RequestBody surveyId,
                                 @Part("videoSize") RequestBody videoSize,
                                 @Part("checkpointId") RequestBody checkpointId,
                                 @Part("value") RequestBody value,
                                 @Part("dateTime") RequestBody dateTime,
                                 @Part("timestamp") RequestBody timestamp


    );

}
