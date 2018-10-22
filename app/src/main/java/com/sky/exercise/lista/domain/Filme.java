package com.sky.exercise.lista.domain;

public class Filme {

    private String title;
    private String overview;
    private String duration;
    private String release_year;
    private String cover_url;
    private String[] backdrops_url;
    private String id;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public void setBackdrops_url(String[] backdrops_url) {
        this.backdrops_url = backdrops_url;
    }

    public void setId(String id) {
        this.id = id;
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
}
