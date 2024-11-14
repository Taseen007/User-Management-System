class RegularUser extends User {
    public RegularUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Regular");
    }

    public void viewData() {
        System.out.println("Regular user viewing data.");
    }
}
