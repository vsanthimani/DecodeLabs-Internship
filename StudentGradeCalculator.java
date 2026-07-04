import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("========================================");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();

        int total = 0;

        for (int i = 1; i <= subjects; i++) {

            int marks;

            while (true) {
                System.out.print("Enter marks for Subject " + i + " (0-100): ");
                marks = sc.nextInt();

                if (marks >= 0 && marks <= 100) {
                    break;
                } else {
                    System.out.println("Invalid Marks! Please enter between 0 and 100.");
                }
            }

            total += marks;
        }

        double average = (double) total / subjects;

        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n========================================");
        System.out.println("            RESULT");
        System.out.println("========================================");
        System.out.println("Student Name : " + name);
        System.out.println("Subjects     : " + subjects);
        System.out.println("Total Marks  : " + total);
        System.out.printf("Average      : %.2f%%\n", average);
        System.out.println("Grade        : " + grade);

        if (grade == 'F') {
            System.out.println("Status       : FAIL");
        } else {
            System.out.println("Status       : PASS");
        }

        System.out.println("========================================");
        System.out.println("Thank You!");
        sc.close();
    }
}
