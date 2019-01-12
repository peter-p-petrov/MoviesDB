package com.tusofia.movies.models.binding;

public class CreateMovieBindingModel {
    private String cover;
    private String title;
    private String genre;
    private Integer year;
    private String director;
    private String country;
    private String trailer;
    private String description;

    public CreateMovieBindingModel(){ }

    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getTrailer() { return trailer; }
    public void setTrailer(String trailer) { this.trailer = trailer; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
