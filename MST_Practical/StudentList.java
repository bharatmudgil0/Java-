import java.util.*;
class EmptyListException extends Exception {
    public EmptyListException(String message) {
        super(message);
    }
}

public class StudentList {
    private static ArrayList<String> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter student name to add: ");
        String name = sc.next();
        students.add(name);
        System.out.println(name + " added successfully.");
    }

    public static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = sc.next();
        if (students.remove(name)) {
            System.out.println(name + " removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public static void displayStudents() throws EmptyListException {
        if (students.isEmpty()) {
            throw new EmptyListException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student List Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    try {
                        displayStudents();
                    } catch (EmptyListException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}
