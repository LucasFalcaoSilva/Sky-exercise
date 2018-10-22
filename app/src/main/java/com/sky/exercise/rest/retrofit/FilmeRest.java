package com.sky.exercise.rest.retrofit;

import com.sky.exercise.rest.domain.FilmesSO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmeRest {

    @GET("/api/Movies")
    Call<List<FilmesSO>> receberFilmes();

}
