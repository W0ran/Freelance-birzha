package models;

public class Freelancer {
    private int id;
    private String name;
    private String skills;
    private double rating;

    public Freelancer(int id, String name, String skills, double rating) {
        this.id = id;
        this.name = name;
        this.skills = skills;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                ", rating=" + rating +
                '}';
    }
}
