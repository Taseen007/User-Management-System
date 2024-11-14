import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FileHandler {

    public static List<User> readUsers(String filePath) {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String userID = data[0];
                String username = data[1];
                String email = data[2];
                String password = data[3];
                String userType = data.length > 4 ? data[4] : "Admin";

                User user;
                if (userType.equals("Regular")) {
                    user = new RegularUser(userID, username, email, password);
                } else if (userType.equals("Power")) {
                    user = new PowerUser(userID, username, email, password);
                } else {
                    user = new AdminUser(userID, username, email, password);
                }
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void writeUsers(String filePath, List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                bw.write(user.getUserID() + "," + user.getUsername() + "," +
                        user.getEmail() + "," + user.getPassword() + "," + user.getUserType());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
