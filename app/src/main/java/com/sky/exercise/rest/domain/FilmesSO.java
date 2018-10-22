package com.sky.exercise.rest.domain;

import com.sky.exercise.lista.domain.Filme;

import java.util.ArrayList;
import java.util.List;

public class FilmesSO {

    private String title;
    private String overview;
    private String duration;
    private String release_year;
    private String cover_url;
    private String[] backdrops_url;
    private String id;

    public FilmesSO() {
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getDuration() {
        return duration;
    }

    public String getRelease_year() {
        return release_year;
    }

    public String getCover_url() {
        return cover_url;
    }

    public String[] getBackdrops_url() {
        return backdrops_url;
    }

    public String getId() {
        return id;
    }

    public static List<Filme> getFilmes(List<FilmesSO> filmesSO) {
        List<Filme> filmes = new ArrayList<>();

        if (filmesSO == null)
            return new ArrayList<>();

        for (FilmesSO so : filmesSO) {

            filmes.add(converterFilme(so));

        }

        return filmes;
    }

    private static Filme converterFilme(FilmesSO filmesSO) {
        Filme filme = new Filme();

        filme.setTitle(filmesSO.getTitle());
        filme.setBackdrops_url(filmesSO.getBackdrops_url());
        filme.setCover_url(filmesSO.getCover_url());
        filme.setDuration(filmesSO.getDuration());
        filme.setId(filme.getId());
        filme.setOverview(filmesSO.getOverview());
        filme.setRelease_year(filmesSO.getRelease_year());

        return filme;

    }
}
