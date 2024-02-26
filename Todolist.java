package Task2;
import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        isDone = true;
    }
}

public class Todolist {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    public Todolist() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void markTaskDone(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markDone();
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void showTasks() {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            String status = task.isDone() ? "[Done]" : "[ ]";
            System.out.println(i + ". " + status + " " + task.getDescription());
        }
    }

    public void run() {
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Done");
            System.out.println("3. Show Tasks");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    addTask(description);
                    break;
                case 2:
                    showTasks();
                    System.out.print("Enter task index to mark as done: ");
                    int index = scanner.nextInt();
                    markTaskDone(index);
                    break;
                case 3:
                    showTasks();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void main(String[] args) {
        Todolist toDoList = new Todolist();
        toDoList.run();
    }
}
