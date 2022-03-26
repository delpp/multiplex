package io.github.delpp.multiplex.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Multiplex {
    List<Movie> moviesInMultiplex = new ArrayList<>();
    List<ScreeningRoom> screeningRooms = new ArrayList<>();

    public Multiplex() {
    }

//    public void addScreeningRoom(String name){
//        screeningRooms.add(new ScreeningRoom(name));
//    }

    public void addMovie(String title, int length){
        moviesInMultiplex.add(new Movie(title, length));
    }

    public Optional<Movie> getMovieByTitle(String title){
        return moviesInMultiplex.stream().filter(x -> x.getTitle().equals(title)).findFirst();
    }

//    public Optional<ScreeningRoom> getScreeningRoomByName(String name){
//        return screeningRooms.stream().filter(x -> x.getName().equals(name)).findFirst();
//    }

    @Override
    public String toString() {
        return "Multiplex{" +
                "moviesInMultiplex=" + moviesInMultiplex +
                ", screeningRooms=" + screeningRooms +
                '}';
    }
}
