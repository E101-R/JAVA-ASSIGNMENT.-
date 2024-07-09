import java.util.Scanner;

public class ExamProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            // Display menu
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewCourseworkResults();
                    break;
                case 2:
                    viewExamResults();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Function to view coursework results
    private static void viewCourseworkResults() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks for the following assessments (out of 100):");
        System.out.print("Assignment 1: ");
        double ass1 = scanner.nextDouble();
        System.out.print("Assignment 2: ");
        double ass2 = scanner.nextDouble();
        System.out.print("Assignment 3: ");
        double ass3 = scanner.nextDouble();
        System.out.print("CAT 1: ");
        double cat1 = scanner.nextDouble();
        System.out.print("CAT 2: ");
        double cat2 = scanner.nextDouble();

        double courseworkTotal = calculateCoursework(ass1, ass2, ass3, cat1, cat2);
        System.out.println("Coursework Total (50%): " + courseworkTotal);
        
        // Check if the student has completed 2/3 of the coursework
        boolean isQualified = checkCourseworkCompletion(courseworkTotal);
        if (isQualified) {
            System.out.println("Student has completed 2/3 of the coursework.");
        } else {
            System.out.println("Student has not completed 2/3 of the coursework and must repeat the course.");
        }
    }

    // Function to calculate coursework total
    private static double calculateCoursework(double ass1, double ass2, double ass3, double cat1, double cat2) {
        return (ass1 + ass2 + ass3 + cat1 + cat2) / 5 * 0.5;
    }

    // Function to check if student has completed 2/3 of the coursework
    private static boolean checkCourseworkCompletion(double courseworkTotal) {
        return courseworkTotal >= 0.67 * 50;
    }

    // Function to view exam results
    private static void viewExamResults() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter final exam mark (out of 100): ");
        double finalExamMark = scanner.nextDouble();

        System.out.println("Final Exam Total (50%): " + finalExamMark * 0.5);
        System.out.print("Enter coursework total (50%): ");
        double courseworkTotal = scanner.nextDouble();

        double totalScore = finalExamMark * 0.5 + courseworkTotal;
        System.out.println("Total Score: " + totalScore);
    }
}
