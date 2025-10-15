import java.util.ArrayList;
import java.util.Scanner;

public class student_grade_tracker {

    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        // Method to calculate letter grade
        String getGradeCategory() {
            if (grade >= 90) return "A";
            else if (grade >= 80) return "B";
            else if (grade >= 70) return "C";
            else if (grade >= 60) return "D";
            else return "F";
        }

        // Method to return remark based on grade
        String getRemarks() {
            if (grade >= 90) return "Excellent";
            else if (grade >= 80) return "Very Good";
            else if (grade >= 70) return "Good";
            else if (grade >= 60) return "Needs Improvement";
            else return "Poor";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("===== Student Grade Tracker =====");
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // consume newline

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter " + name + "'s grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine();  // consume newline

            students.add(new Student(name, grade));
        }

        // Processing grades
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;

        for (Student s : students) {
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }

        double average = total / students.size();

        // Display enhanced summary
        System.out.println("\n===== Categorized Student Report =====");
        System.out.printf("%-15s %-10s %-10s %-20s\n", "Name", "Grade", "Category", "Remarks");
        System.out.println("-----------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-15s %-10.2f %-10s %-20s\n", s.name, s.grade, s.getGradeCategory(), s.getRemarks());
        }

        System.out.println("\n===== Overall Stats =====");
        System.out.printf("Total Students: %d\n", students.size());
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.printf("Highest Grade: %.2f\n", highest);
        System.out.printf("Lowest Grade: %.2f\n", lowest);

        scanner.close();
    }
}
