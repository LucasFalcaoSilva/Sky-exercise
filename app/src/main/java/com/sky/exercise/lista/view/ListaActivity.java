package com.sky.exercise.lista.view;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sky.exercise.R;
import com.sky.exercise.base.BaseActivity;
import com.sky.exercise.lista.ListaMVP;
import com.sky.exercise.lista.presenter.ListaPresenter;
import com.sky.exercise.lista.view.adapter.FilmesAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_lista)
public class ListaActivity extends BaseActivity implements ListaMVP.ListaView {

    @Bean
    protected ListaPresenter presenter;

    @ViewById(R.id.pgb_loading)
    ProgressBar pgbLoading;

    @ViewById(R.id.rv_lista_filmes)
    RecyclerView rvListaFilmes;

    @ViewById(R.id.txt_info_filmes)
    TextView txtInfoFilmes;

    @AfterInject
    protected void iniciar() {
        super.carregarTitulo(getString(R.string.titulo_lista));

        presenter.setView(this);
    }

    @AfterViews
    protected void carregar() {
        iniciarGrid();
        txtInfoFilmes.setText(R.string.info_filmes);
        presenter.carregarFilmes();
    }

    @Override
    public void iniciarGrid() {
        rvListaFilmes.setLayoutManager(new GridLayoutManager(this, 2));
        rvListaFilmes.setHasFixedSize(true);
    }

    @Override
    @UiThread
    public void atualizarGrid(FilmesAdapter filmesAdapter) {
        rvListaFilmes.setAdapter(filmesAdapter);
        filmesAdapter.notifyDataSetChanged();
    }

    @Override
    @UiThread
    public void exibirProgress(boolean exibir) {
        pgbLoading.setVisibility(exibir ? View.VISIBLE : View.GONE);
        rvListaFilmes.setVisibility(exibir ? View.GONE : View.VISIBLE);
        txtInfoFilmes.setVisibility(exibir ? View.GONE : View.VISIBLE);
    }
}
