package com.sky.exercise.lista.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.sky.exercise.base.ViewWrapper;
import com.sky.exercise.lista.domain.Filme;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class FilmesAdapter extends RecyclerView.Adapter<ViewWrapper>{

    @RootContext
    Context mContext;

    private List<Filme> filmes;

    private OnItemClickListener onItemClickListener;

    @Override
    public ViewWrapper onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper(FilmeListaItem_.build(mContext));
    }

    @Override
    public void onBindViewHolder(ViewWrapper holder, int position) {
        final Filme filme = filmes.get(position);
        ((FilmeListaItem)holder.getView()).bind(filme,onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Filme filme);
    }
}
