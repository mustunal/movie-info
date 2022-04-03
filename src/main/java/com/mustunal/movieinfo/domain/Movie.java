package com.mustunal.movieinfo.domain;

public class Movie {
    private long id;
    private String name;
    private long directorId;
    private Director director;

    public Movie(long id, String name, long directorId) {
        this.id = id;
        this.name = name;
        this.directorId = directorId;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(long directorId) {
        this.directorId = directorId;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
