import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private List<User> admins = new ArrayList<>();

    public void loadUsers() {
        users = FileHandler.readUsers("src/User.csv");
        admins = FileHandler.readUsers("src/Admin.csv");
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        for (User admin : admins) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null; // Authentication failed
    }

    public void saveUsers() {
        FileHandler.writeUsers("User.csv", users);
        FileHandler.writeUsers("Admin.csv", admins);
    }

    public void addUser(User user) {
        users.add(user);
        saveUsers();
    }
}
