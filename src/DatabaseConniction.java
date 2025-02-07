import java.sql.*;
import java.util.Scanner;

public class DatabaseConniction {

    static String url = "jdbc:postgresql://localhost:5432/postgres"; // Замените на свой адрес и название базы данных
    static String user = "postgres";
    static String password = "12341234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Add Freelancer");
            System.out.println("2. Delete Freelancer ");
            System.out.println("3. Show All Freelancers");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Для захвата остаточного символа новой строки

            switch (choice) {
                case 1:
                    // Добавить фрилансера
                    System.out.print("Введите имя фрилансера: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите навыки фрилансера: ");
                    String skills = scanner.nextLine();
                    System.out.print("Введите рейтинг фрилансера: ");
                    double rating = scanner.nextDouble();
                    addFreelancer(name, skills, rating);
                    break;
                case 2:
                    // Удалить фрилансера
                    System.out.print("Введите ID фрилансера для удаления: ");
                    int freelancerId = scanner.nextInt();
                    deleteFreelancer(freelancerId);
                    break;
                case 3:
                    // Показать всех фрилансеров
                    showAllFreelancers();
                    break;
                case 4:
                    // Выход
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод для добавления фрилансера
    public static void addFreelancer(String name, String skills, double rating) {
        String query = "INSERT INTO Freelancers (name, skills, rating) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, skills);
            pstmt.setDouble(3, rating);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Фрилансер добавлен: " + name);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении фрилансера: " + e.getMessage());
        }
    }

    // Метод для удаления фрилансера
    public static void deleteFreelancer(int freelancerId) {
        String query = "DELETE FROM Freelancers WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, freelancerId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Фрилансер с ID " + freelancerId + " был удалён.");
            } else {
                System.out.println("Фрилансер с таким ID не найден.");
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении фрилансера: " + e.getMessage());
        }
    }

    // Метод для показа всех фрилансеров
    public static void showAllFreelancers() {
        String query = "SELECT * FROM Freelancers";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Skills: " + rs.getString("skills") +
                        ", Rating: " + rs.getDouble("rating"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении списка фрилансеров: " + e.getMessage());
        }
    }
}
