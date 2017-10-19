/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.dvdId;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + this.releaseYear;
        hash = 41 * hash + Objects.hashCode(this.director);
        hash = 41 * hash + Objects.hashCode(this.rating);
        hash = 41 * hash + Objects.hashCode(this.notes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (this.dvdId != other.dvdId) {
            return false;
        }
        if (this.releaseYear != other.releaseYear) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.notes, other.notes)) {
            return false;
        }
        return true;
    }
    
}
