package models;

public class JobListing {
    private int id;
    private String category;
    private String description;
    private double price;

    public JobListing(int id, String category, String description, double price) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "JobListing{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
