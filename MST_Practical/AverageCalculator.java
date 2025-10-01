import java.util.*;

public class AverageCalculator {
    private static ArrayList<Integer> numbers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void addNumber() {
        System.out.print("Enter a number (or type 'done' to stop): ");
        String input = sc.next();
        if (input.equalsIgnoreCase("done")) return;

        try {
            int num = Integer.parseInt(input);
            numbers.add(num);
            System.out.println(num + " added.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input, please enter a valid integer.");
        }
    }

    public static void calculateAverage() {
        try {
            if (numbers.isEmpty()) {
                throw new ArithmeticException("Cannot divide by zero — list is empty.");
            }
            double sum = 0;
            for (int n : numbers) sum += n;
            double avg = sum / numbers.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayNumbers() {
        System.out.println("Numbers entered: " + numbers);
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Average Calculator Menu ---");
            System.out.println("1. Add Number");
            System.out.println("2. Display Numbers");
            System.out.println("3. Calculate Average");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addNumber();
                    break;
                case 2:
                    displayNumbers();
                    break;
                case 3:
                    calculateAverage();
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
