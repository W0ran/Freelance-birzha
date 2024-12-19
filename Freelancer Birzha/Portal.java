public class Portal {
    public static void main(String[] args) {
        JobListing job1 = new JobListing("Web Development", "Build a website for a local business", 500.0);
        JobListing job2 = new JobListing("Mobile App", "Create a fitness tracking app", 1000.0);

        Freelancer freelancer1 = new Freelancer("Alice", "Java, HTML, CSS", 4.8);
        Freelancer freelancer2 = new Freelancer("Bob", "Kotlin, Android Development", 4.5);

        System.out.println("Job Listings:");
        System.out.println(job1);
        System.out.println(job2);

        System.out.println("\nFreelancers:");
        System.out.println(freelancer1);
        System.out.println(freelancer2);

        if (job1.getBudget() > job2.getBudget()) {
            System.out.println("\nJob 1 has a higher budget than Job 2.");
        } else if (job1.getBudget() < job2.getBudget()) {
            System.out.println("\nJob 2 has a higher budget than Job 1.");
        } else {
            System.out.println("\nBoth jobs have the same budget.");
        }
    }
}