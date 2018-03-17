package models;

import behaviours.IPay;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film implements IPay{

    private int id;
    private String title;
    private String genre;
    private int duration;
    private int budget;
    private Studio studio;
    private Director director;
    private Set<Actor_Actress> actors_actresses;


    public Film() {
    }

    public Film(String title, String genre, int duration, int budget, Studio studio, Director director) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.budget = budget;
        this.studio = studio;
        this.director = director;
        this.actors_actresses = new HashSet<Actor_Actress>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @ManyToMany(mappedBy = "films", fetch = FetchType.EAGER)
    public Set<Actor_Actress> getActors_actresses() {
        return actors_actresses;
    }

    public void setActors_actresses(Set<Actor_Actress> actors_actresses) {
        this.actors_actresses = actors_actresses;
    }

    public int calculatePay() {
        return (int)(this.budget * 0.1);
//        int result = (int)(this.budget - percentage);
//        return percentage;
    }

    public void addStar(Actor_Actress actor_actress){
        this.actors_actresses.add(actor_actress);
    }
}
