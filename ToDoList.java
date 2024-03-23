import java.util.ArrayList;
import java.util.Scanner;

// Task class to represent individual tasks
class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isComplete;

    // Constructor to initialize task attributes
    public Task(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isComplete = false;
    }

    // Getter methods for task attributes
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isComplete() {
        return isComplete;
    }

    // Method to mark task as complete
    public void markComplete() {
        isComplete = true;
    }
}

// Main class for the To-Do List application
public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>(); // ArrayList to store tasks
    private static Scanner sc = new Scanner(System.in); // Scanner object for user input

    public static void main(String[] args) {
        System.out.println("\nWelcome to the ToDo List Application!");
        displayMenu(); // Display the main menu
    }

    // Method to display the main menu and handle user input
    private static void displayMenu() {
        int choice;
        do {
            // Display menu options
            System.out.println("\n===== To-Do List Menu =====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); // Read user choice
            sc.nextLine(); // Consume newline character

            // Handle user choice
            switch (choice) {
                case 1:
                    addTask(); // Add a new task
                    break;
                case 2:
                    markTaskAsComplete(); // Mark a task as complete
                    break;
                case 3:
                    viewTasks(); // View all tasks
                    break;
                case 4:
                    removeTask(); // Remove a task
                    break;
                case 5:
                    System.out.println("Thank you for visiting..."); // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice! Please try again..."); // Handle invalid input
            }
        } while (choice != 5); // Continue until user chooses to exit
    }

    // Method to add a new task
    private static void addTask() {
        System.out.println("\n===== Add Task =====");
        // Prompt user for task details
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        System.out.print("Enter task description: ");
        String description = sc.nextLine();
        System.out.print("Enter due date: ");
        String dueDate = sc.nextLine();
        // Create new task and add it to the task list
        Task task = new Task(title, description, dueDate);
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    // Method to mark a task as complete
    private static void markTaskAsComplete() {
        System.out.println("\n===== Mark Task as Complete =====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available."); // Display message if no tasks are available
            return;
        }
        viewTasks(); // Display tasks to the user
        System.out.print("Enter the index of the task to mark as complete: ");
        int index = sc.nextInt(); // Read user input
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid index."); // Handle invalid index
            return;
        }
        tasks.get(index - 1).markComplete(); // Mark the selected task as complete
        System.out.println("Task marked as complete.");
    }

    // Method to view all tasks
    private static void viewTasks() {
        System.out.println("\n===== View Tasks =====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available."); // Display message if no tasks are available
            return;
        }
        // Display details of each task
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("Index: " + (i + 1));
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Status: " + (task.isComplete() ? "Complete" : "Incomplete"));
            System.out.println();
        }
    }

    // Method to remove a task
    private static void removeTask() {
        System.out.println("\n===== Remove Task =====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available."); // Display message if no tasks are available
            return;
        }
        viewTasks(); // Display tasks to the user
        System.out.print("Enter the index of the task to remove: ");
        int index = sc.nextInt(); // Read user input
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid index."); // Handle invalid index
            return;
        }
        tasks.remove(index - 1); // Remove the selected task
        System.out.println("Task removed successfully.");
    }
}
