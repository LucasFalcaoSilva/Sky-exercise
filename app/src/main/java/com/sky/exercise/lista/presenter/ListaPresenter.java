package com.sky.exercise.lista.presenter;

import com.sky.exercise.lista.ListaMVP;
import com.sky.exercise.lista.domain.Filme;
import com.sky.exercise.lista.model.ListaModel;
import com.sky.exercise.lista.view.adapter.FilmesAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ListaPresenter implements ListaMVP.ListaPresenter {

    private ListaMVP.ListaView listaView;

    @Bean
    protected ListaModel listaModel;

    @Bean
    protected FilmesAdapter adapter;

    @AfterInject
    protected void iniciarPresenter() {
        listaModel.setPresenter(this);
    }

    @Override
    public void carregarFilmes() {
        listaView.exibirProgress(true);
        listaModel.buscarFilmes();
    }

    @Override
    public void atualizarGrid(List<Filme> listaFilmes) {
        adapter.setFilmes(listaFilmes);
        listaView.atualizarGrid(adapter);
        listaView.exibirProgress(false);
    }

    @Override
    public void setView(ListaMVP.ListaView listaView) {
        this.listaView = listaView;
    }
}
