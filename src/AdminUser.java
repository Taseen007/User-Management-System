class AdminUser extends User {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Admin");
    }

    public void modifyUser(User user, String newEmail, String newPassword) {
        System.out.println("Admin modifying user details.");
        user.email = newEmail;
        user.password = newPassword;
    }
}