import models.JobListing;
import models.Freelancer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Portal {
    private Connection connection;

    public Portal() {
        try {
            // Подключение к базе данных PostgreSQL
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", // Укажите свой адрес БД
                    "postgres", // Укажите имя пользователя
                    "12341234" // Укажите пароль
            );
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к базе данных: " + e.getMessage());
        }
    }

    public List<JobListing> getAllJobListings() {
        List<JobListing> jobListings = new ArrayList<>();
        String query = "SELECT * FROM JobListings";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                jobListings.add(new JobListing(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении вакансий: " + e.getMessage());
        }
        System.out.println("Количество вакансий: " + jobListings.size());
        return jobListings;
    }

    public List<Freelancer> getAllFreelancers() {
        List<Freelancer> freelancers = new ArrayList<>();
        String query = "SELECT * FROM Freelancers";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                freelancers.add(new Freelancer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("skills"),
                        rs.getDouble("rating")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении фрилансеров: " + e.getMessage());
        }
        System.out.println("Количество фрилансеров: " + freelancers.size());
        return freelancers;
    }

    public List<JobListing> filterJobListingsByBudget(double budget) {
        List<JobListing> filteredJobs = new ArrayList<>();
        String query = "SELECT * FROM JobListings WHERE price > ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setDouble(1, budget);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    filteredJobs.add(new JobListing(
                            rs.getInt("id"),
                            rs.getString("category"),
                            rs.getString("description"),
                            rs.getDouble("price")
                    ));
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при фильтрации вакансий: " + e.getMessage());
        }
        return filteredJobs;
    }

    public Freelancer findFreelancerByName(String name) {
        String query = "SELECT * FROM Freelancers WHERE name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Freelancer(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("skills"),
                            rs.getDouble("rating")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при поиске фрилансера: " + e.getMessage());
        }
        return null;
    }
}
