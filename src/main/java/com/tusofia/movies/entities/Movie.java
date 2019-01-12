package com.tusofia.movies.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    private String id;
    private String cover;
    private String title;
    private String genre;
    private Integer year;
    private String director;
    private String country;
    private String description;
    private String trailer;

    public Movie(){ }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @Column(name = "cover", nullable = false)
    public String getCover() { return cover; }
    public void setCover(String cover) { this.cover = cover; }

    @Column(name = "title", nullable = false)
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    @Column(name = "genre", nullable = false)
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Column(name = "year", nullable = false)
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    @Column(name = "director", nullable = false)
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    @Column(name = "country", nullable = false)
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Column(name = "description", nullable = false)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Column(name = "trailer", nullable = false)
    public String getTrailer() { return trailer; }
    public void setTrailer(String trailer) { this.trailer = trailer; }

    public String extractMovieAsString(){
        return String.format("%s%nGenre: %s,%nYear: %d,%nDirector: %s,%nCountry: %s,%nDescription: %s,%nRating: %.2f "
                , this.getTitle().toUpperCase(), this.getGenre(), this.getYear(), this.getDirector(), this.getCountry(), this.getDescription());
    }
}