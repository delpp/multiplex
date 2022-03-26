package io.github.delpp.multiplex.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int lengthInMinutes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<Projection> projections;

    public Movie() {
    }

    public Movie(String title, int length) {
        this.title = title;
        this.lengthInMinutes = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                '}';
    }
}
