import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.loadUsers(); // Load users from CSV files

        // Test authentication for regular user
        User authenticatedUser = userManager.authenticate("john_doe", "12345");
        if (authenticatedUser != null && authenticatedUser.getUserType().equals("Regular")) {
            System.out.println("Test passed: Regular user authenticated successfully.");
        } else {
            System.out.println("Test failed: Regular user authentication failed.");
        }

        // Test authentication for admin user
        User authenticatedAdmin = userManager.authenticate("admin", "adminPass");
        if (authenticatedAdmin != null && authenticatedAdmin.getUserType().equals("Admin")) {
            System.out.println("Test passed: Admin user authenticated successfully.");
        } else {
            System.out.println("Test failed: Admin user authentication failed.");
        }
    }
}



