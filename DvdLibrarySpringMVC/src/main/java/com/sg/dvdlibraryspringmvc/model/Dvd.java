/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.model;

/**
 *
 * @author jstuart15
 */
public class Dvd {

    private int dvdId;
    private String title;
    private int releaseYear;
    private String director;
    private String rating;
    private String notes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    @Override
    public String toString() {
        return "Item: " + dvdId
                + " |Title: " + title
                + " |Release Date: " + releaseYear
                + " |MPAA Rating: " + rating
                + " |Director's Name: " + director
                + " |Comments: " + notes;
    }
}
