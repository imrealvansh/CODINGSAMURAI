import java.util.*;

public class Calculator {
    // Addition Function
    public static float add(float num1, float num2) {
        float result = num1 + num2;
        return result;
    }

    // Subtraction Function
    public static float sub(float num1, float num2) {
        float result = num1 - num2;
        return result;
    }

    // Multiplication Function
    public static float multi(float num1, float num2) {
        float result = num1 * num2;
        return result;
    }

    // Division Function
    public static float div(float num1, float num2) {
        if (num2 == 0) {
            System.out.println("Error: Division by zero!");
            return 0; // Handle division by zero gracefully
        }
        float result = num1 / num2;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int op;
        do {
            // Calculator logic
            System.out.println("-------------------------------------------");
            System.out.println("\t\tCalculator");
            System.out.println("-------------------------------------------");

            System.out.print("Please Enter 1st Number: ");
            float num1 = sc.nextFloat();
            System.out.print("Please Enter 2nd Number: ");
            float num2 = sc.nextFloat();

            System.out.println();
            System.out.println("-------------------------------------------");
            System.out.println("Please Select An Arithmatic Operation");
            System.out.println("-------------------------------------------");
            System.out.println("1.Addition\t\t2.Substraction\n3.Multiplication\t4.Division");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------");

            System.out.print("Operation: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println(add(num1, num2));
                    break;
                case 2:
                    System.out.println(sub(num1, num2));
                    break;
                case 3:
                    System.out.println(multi(num1, num2));
                    break;
                case 4:
                    System.out.println(div(num1, num2));
                    break;
                case 5:
                    System.out.println("Exiting calculator...");
                    break;
                default:
                    System.out.println("Invalid operation choice!");
            }

        } while (op != 5); // Loop continues until user chooses exit (option 5)

        sc.close(); // Close Scanner to avoid resource leaks
    }
}
