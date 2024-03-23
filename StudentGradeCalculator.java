import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt user to input the number of subjects

        System.out.println("========================================================");
        System.out.println("\tWelcome to the Student Grade Calculator!");
        System.out.println("========================================================");
        System.out.print("Enter the number of subjects you have: ");
        int nSubjects = sc.nextInt();
        System.out.println("Please enter your grades for the following components:");
        System.out.println();
        // Array to store grades for each subject
        double[] grades = new double[nSubjects];
        double totalGrade = 0;

        // Input grades for each subject
        for (int i = 0; i < nSubjects; i++) {
            System.out.println("---------------------------");
            System.out.println("Enter grades for Subject " + (i + 1) + ": ");
            System.out.println("---------------------------");

            double assignmentsGrade, quizzesGrade, midtermGrade, finalExamGrade;
            do {
                try {
                    System.out.print("Assignments Grade (out of 100): ");
                    assignmentsGrade = sc.nextDouble();
                    if (assignmentsGrade < 0 || assignmentsGrade > 100) {
                        System.out.println("Invalid marks entry! Marks should be between 0 and 100.");
                        continue;
                    }
                    System.out.print("Quizzes Grade (out of 100): ");
                    quizzesGrade = sc.nextDouble();
                    if (quizzesGrade < 0 || quizzesGrade > 100) {
                        System.out.println("Invalid marks entry! Marks should be between 0 and 100.");
                        continue;
                    }
                    System.out.print("Midterm Exam Grade (out of 100): ");
                    midtermGrade = sc.nextDouble();
                    if (midtermGrade < 0 || midtermGrade > 100) {
                        System.out.println("Invalid marks entry! Marks should be between 0 and 100.");
                        continue;
                    }
                    System.out.print("Final Exam Grade (out of 100): ");
                    finalExamGrade = sc.nextDouble();
                    if (finalExamGrade < 0 || finalExamGrade > 100) {
                        System.out.println("Invalid marks entry! Marks should be between 0 and 100.");
                        continue;
                    }
                    // Calculate overall grade for the subject
                    double overallGrade = (assignmentsGrade + quizzesGrade + midtermGrade + finalExamGrade) / 4.0;
                    grades[i] = overallGrade;
                    totalGrade += overallGrade; // Accumulate total grade
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter only numbers.");
                    sc.nextLine(); // Clear input buffer
                }
            } while (true);
        }

        // Calculate average grade for all subjects
        double averageGrade = totalGrade / nSubjects;

        // Determine letter grade
        String letterGrade;
        if (averageGrade >= 95) {
            letterGrade = "A+";
        } else if (averageGrade >= 85) {
            letterGrade = "A";
        } else if (averageGrade >= 75) {
            letterGrade = "B+";
        } else if (averageGrade >= 65) {
            letterGrade = "B";
        } else if (averageGrade >= 55) {
            letterGrade = "C+";
        } else if (averageGrade >= 40) {
            letterGrade = "C";
        } else if (averageGrade >= 33) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        // Display result
        System.out.println("\nPercentage: " + averageGrade + "%");
        System.out.println("Grade: " + letterGrade);

        sc.close();
    }
}
