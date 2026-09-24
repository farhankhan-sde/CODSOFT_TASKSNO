maimport java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("=================================");

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        if (subjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            sc.close();
            return;
        }

        double total = 0;

        for (int i = 1; i <= subjects; i++) {
            double marks;

            do {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                marks = sc.nextDouble();

                if (marks < 0 || marks > 100) {
                    System.out.println("Invalid marks. Enter a value from 0 to 100.");
                }
            } while (marks < 0 || marks > 100);

            total += marks;
        }

        double average = total / subjects;
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\n----------- RESULT -----------");
        System.out.printf("Total Marks       : %.2f / %d%n", total, subjects * 100);
        System.out.printf("Average Percentage: %.2f%%%n", average);
        System.out.println("Grade             : " + grade);
        System.out.println("------------------------------");

        sc.close();
    }
}
