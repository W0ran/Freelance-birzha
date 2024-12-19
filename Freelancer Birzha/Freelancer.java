public class Freelancer {
    private String name;
    private String skills;
    private double rating;

    public Freelancer(String name, String skills, double rating) {
        this.name = name;
        this.skills = skills;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "name='" + name + '\'' +
                ", skills='" + skills + '\'' +
                ", rating=" + rating +
                '}';
    }
}