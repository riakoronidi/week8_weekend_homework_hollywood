package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors_actresses")
public class Actor_Actress {;

    private int id;
    private String name;
    private int cash;
    private Agent agent;
    private Set<Film> films;

    public Actor_Actress() {
    }

    public Actor_Actress(String name, int cash, Agent agent) {
        this.name = name;
        this.cash = cash;
        this.agent = agent;
        this.films = new HashSet<Film>();
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "cash")
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @ManyToOne
    @JoinColumn(name = "agent_id", nullable = false)
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actor_actress_film",
            joinColumns = {@JoinColumn(name = "actor_actress_id",nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "film_id", nullable = false, updatable = false)}
    )
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film){
        this.films.add(film);
    }

    public void starGetPaid(){
        for (Film film : films)
            this.cash += film.calculatePay();
    }
}

