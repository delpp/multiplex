package io.github.delpp.multiplex.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "projections")
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private LocalDateTime startProjection;
    private LocalDateTime endProjection;

    @ManyToOne
    @JoinColumn(name = "screeningRoom_id")
    private ScreeningRoom screeningRoom;


    public Projection(Movie movie, LocalDateTime startProjection) {
        this.movie = movie;
        this.startProjection = startProjection;
        endProjection = startProjection.plusMinutes(movie.getLengthInMinutes());
        System.out.println("Utworzono projekcję");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getStartProjection() {
        return startProjection;
    }

    public void setStartProjection(LocalDateTime startProjection) {
        this.startProjection = startProjection;
    }

    public LocalDateTime getEndProjection() {
        return endProjection;
    }

    public void setEndProjection(LocalDateTime endProjection) {
        this.endProjection = endProjection;
    }

    public boolean isMyTimeProjection(LocalDateTime dateTime){
        if ((dateTime.isAfter(startProjection)) && (dateTime.isBefore(endProjection)))
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Projection{" +
                "movie=" + movie +
                ", startProjection=" + startProjection +
                '}';
    }
}
