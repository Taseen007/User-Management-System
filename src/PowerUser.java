import java.util.List;

class PowerUser extends User {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Power");
    }

    public void addUser(User user, List<User> users) {
        System.out.println("Power user adding user.");
        users.add(user);
    }
}