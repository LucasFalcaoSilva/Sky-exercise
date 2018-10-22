package com.sky.exercise.lista.model;

import com.sky.exercise.lista.ListaMVP;
import com.sky.exercise.lista.domain.Filme;
import com.sky.exercise.rest.domain.FilmesSO;
import com.sky.exercise.rest.service.FilmeWService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ListaModel implements ListaMVP.ListaModel {

    private ListaMVP.ListaPresenter listaPresenter;

    @Bean
    protected FilmeWService filmeWService;

    @Override
    public void setPresenter(ListaMVP.ListaPresenter listaPresenter) {
        this.listaPresenter = listaPresenter;
    }


    @Override
    @Background(delay = 2000)
    public void buscarFilmes() {
        List<FilmesSO> filmesSO = filmeWService.obterFilmes();

        List<Filme> filmes = FilmesSO.getFilmes(filmesSO);

        listaPresenter.atualizarGrid(filmes);

    }
}
