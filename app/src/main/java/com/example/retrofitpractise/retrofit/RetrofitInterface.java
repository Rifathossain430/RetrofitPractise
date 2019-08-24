package com.example.retrofitpractise.retrofit;

import com.example.retrofitpractise.mojoclass.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitInterface  {

  ///  @GET("comments")
    //Call<List<User>> getData(@Query("postId") int postId);

    //@GET("posts/{id}/comments")
    //Call<List<User>> getData(@Path("id") int id);
    @GET()
    Call<List<User>> getData(@Url String url);

}
