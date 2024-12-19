public class Main {
    public static void main(String[] args) {
        JobListing job1 = new JobListing("Graphic Design", "Design a logo for a startup", 300.0);
        JobListing job2 = new JobListing("Content Writing", "Write 10 blog posts on technology", 600.0);

        Freelancer freelancer1 = new Freelancer("Charlie", "Graphic Design, Photoshop", 4.9);
        Freelancer freelancer2 = new Freelancer("Dave", "Content Writing, SEO", 4.7);

        System.out.println("Job Listings in Main:");
        System.out.println(job1);
        System.out.println(job2);

        System.out.println("\nFreelancers in Main:");
        System.out.println(freelancer1);
        System.out.println(freelancer2);

        if (job1.getBudget() > job2.getBudget()) {
            System.out.println("\nJob 1 has a higher budget than Job 2 in Main.");
        } else if (job1.getBudget() < job2.getBudget()) {
            System.out.println("\nJob 2 has a higher budget than Job 1 in Main.");
        } else {
            System.out.println("\nBoth jobs have the same budget in Main.");
        }
    }
}
