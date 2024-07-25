package onlineexam;
import java.util.Scanner;

public class User {
    private String username = "admin";
    private String password = "password";
    private String name = "Admin User";

    public boolean login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter your password: ");
        String inputPassword = scanner.nextLine();

        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }

    public void updateProfile(Scanner scanner) {
        System.out.print("Enter your new name: ");
        name = scanner.nextLine();
        System.out.println("Profile updated successfully!");
    }

    public void changePassword(Scanner scanner) {
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();

        if (password.equals(currentPassword)) {
            System.out.print("Enter your new password: ");
            password = scanner.nextLine();
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Incorrect current password.");
        }
    }
}
