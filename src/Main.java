import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import models.JobListing;
import models.Freelancer;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal();

        System.out.println("Все вакансии:");
        for (JobListing job : portal.getAllJobListings()) {
            System.out.println(job);
        }

        System.out.println("\nВсе фрилансеры:");
        for (Freelancer freelancer : portal.getAllFreelancers(*)) {
            System.out.println(freelancer);
        }

        // Фильтровать списки вакансий по бюджету > 400
        System.out.println("\nОтфильтрованные вакансии (бюджет > 400):");
        for (JobListing job : portal.filterJobListingsByBudget(400)) {
            System.out.println(job);
        }

        // Найдите фрилансера по имени
        System.out.println("\nПоиск фрилансера по имени 'Алиса':");
        Freelancer foundFreelancer = portal.findFreelancerByName("Алиса");
        if (foundFreelancer != null) {
            System.out.println(foundFreelancer);
        } else {
            System.out.println("Фрилансер не найден.");
        }
    }
}
