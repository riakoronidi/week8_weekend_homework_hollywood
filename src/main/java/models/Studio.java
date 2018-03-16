package models;

import javax.persistence.*;

@Entity
@Table(name="studios")
public class Studio {

    private int id;
    private String name;
    private String location;
    private int bugdet;

    public Studio() {
    }

    public Studio(String name, String location, int bugdet) {
        this.name = name;
        this.location = location;
        this.bugdet = bugdet;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
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

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="budget")
    public int getBugdet() {
        return bugdet;
    }

    public void setBugdet(int bugdet) {
        this.bugdet = bugdet;
    }
}
