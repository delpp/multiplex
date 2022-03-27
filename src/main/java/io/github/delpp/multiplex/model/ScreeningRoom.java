package io.github.delpp.multiplex.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "screeningRooms")
public class ScreeningRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screeningRoom")
    private List<Projection> projections;

    public ScreeningRoom() {
    }

    public ScreeningRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addProjection (Projection newProjection){
        if (!projections.isEmpty()) {
            for (Projection registeredProjection : projections) {
                if ((registeredProjection.isMyTimeProjection(newProjection.getStartProjection()))
                        || registeredProjection.isMyTimeProjection(newProjection.getEndProjection())) {
                    System.out.println("W sali: " + name + " w tym czasie jest już emitowany film.");
                    return false;
                } else {
                    projections.add(newProjection);
                    System.out.println("Dodano projekcję do screening room: " + name);
                    return true;
                }
            }
        }
        else{
            projections.add(newProjection);
            System.out.println("Dodano projekcję do screening room: " + name);
        }
        return false;
    }

    public List<Projection> readProjections(){
        return projections;
    }

    @Override
    public String toString() {
        return "ScreeningRoom{" +
                "name='" + name + '\'' +
                ", projections=" + projections +
                '}';
    }
}

