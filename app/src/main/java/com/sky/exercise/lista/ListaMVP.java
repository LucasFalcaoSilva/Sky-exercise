package com.sky.exercise.lista;

import com.sky.exercise.lista.domain.Filme;
import com.sky.exercise.lista.view.adapter.FilmesAdapter;

import java.util.List;

public interface ListaMVP {
    interface ListaPresenter {
        void setView(ListaMVP.ListaView listaView);

        void atualizarGrid(List<Filme> listaFilmes);

        void carregarFilmes();
    }

    interface ListaModel {
        void setPresenter(ListaMVP.ListaPresenter listaPresenter);

        void buscarFilmes();
    }

    interface ListaView {
        void iniciarGrid();

        void exibirProgress(boolean exibir);

        void atualizarGrid(FilmesAdapter veiculoAdapter);
    }
}
