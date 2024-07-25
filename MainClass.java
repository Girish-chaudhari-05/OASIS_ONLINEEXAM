package onlineexam;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        Exam exam = new Exam();
        boolean loggedIn = false;

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Change Password");
            System.out.println("4. Take Exam");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    loggedIn = user.login(scanner);
                    break;
                case 2:
                    if (loggedIn) {
                        user.updateProfile(scanner);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 3:
                    if (loggedIn) {
                        user.changePassword(scanner);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 4:
                    if (loggedIn) {
                        exam.startExam(scanner);
                    } else {
                        System.out.println("Please login first.");
                    }
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                    break;
                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
