package com.sky.exercise.lista.view.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sky.exercise.R;
import com.sky.exercise.lista.domain.Filme;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.filmes_lista_item)
public class FilmeListaItem extends RelativeLayout {

    @ViewById(R.id.txt_titulo)
    TextView txtNomeFilme;

    @ViewById(R.id.img_capa)
    ImageView imgCapaFilme;

    public FilmeListaItem(Context context) {
        super(context);
    }

    public void bind(final Filme filme, FilmesAdapter.OnItemClickListener onItemClickListener) {
        txtNomeFilme.setVisibility(View.VISIBLE);
        Picasso.get()
                .load(filme.getCover_url())
                .resize(500, 800)
                .placeholder(R.drawable.progress_animation)
                .error(R.drawable.ic_error)
                .into(imgCapaFilme, new Callback() {
                    @Override
                    public void onSuccess() {
                        txtNomeFilme.setText(filme.getTitle());
                    }

                    @Override
                    public void onError(Exception e) {
                        txtNomeFilme.setText(R.string.filme_invalido);
                    }
                });
    }

}
