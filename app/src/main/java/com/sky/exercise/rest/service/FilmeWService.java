package com.sky.exercise.rest.service;

import com.sky.exercise.base.BaseService;
import com.sky.exercise.rest.domain.FilmesSO;
import com.sky.exercise.rest.retrofit.FilmeRest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import java.util.List;

import retrofit2.Call;

@EBean
public class FilmeWService extends BaseService {

    private FilmeRest filmeRest;

    @AfterInject
    protected void iniciar() {
        filmeRest = (FilmeRest) retrofitCreate(FilmeRest.class, "sky-exercise.herokuapp.com");
    }

    public List<FilmesSO> obterFilmes() {
        List<FilmesSO> result = null;
        try {

            Call<List<FilmesSO>> call = filmeRest.receberFilmes();

            result = call.execute().body();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
