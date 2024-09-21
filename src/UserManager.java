import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class UserManager {

    //list with users
    private List<User> users;

    public UserManager() {
        users = new ArrayList<>(); //initialize the array
        registerAdmin("Admin", "password", "admin_auto");
    }

    //register user
    public boolean registerUser(String name, String password, String id) {

        //check if id exists
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("User with id " + id + " already exists"); //debugging
                return false;
            }
        }
        //add user
        users.add(new User(name, password, id));
        System.out.println("User with id " + id + " registered successfully"); //debugging
        return true; //registration complete
    }

    //authentication method
    public User authenticateUser(String id, String password, JPanel panel) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                if (user.checkPassword(password)) {
                    if (user.getRole().equals("USER")) {
                        System.out.println("User with id " + id + " authenticated successfully"); //debugging
                        LibraryApp.userPanel(panel);
                        return user; //auth successful
                    } else {
                        System.out.println("User with id " + id + " authenticated as an ADMIN"); //debugging
                        LibraryApp.adminPanel(panel);
                        return user;
                    }

                }

            }
        }
        System.out.println("User with id " + id + " not authenticated"); //debugging
        return null; // auth fail
    }

    //register admin (only admin can register an admin)
    public boolean registerAdmin(String name, String password, String id) {

        //check if id exists
        for (User user : users) {
            if (user.getId().equals(id)) {
                System.out.println("User with id " + id + " already exists"); //debugging
                return false;
            }
        }
        //add user
        users.add(new User(name, password, id));
        promoteToAdmin(id);
        System.out.println("User with id " + id + " registered successfully"); //debugging
        return true; //registration complete
    }

    //changes role from user to admin
    public void promoteToAdmin(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setRole("ADMIN");
                System.out.println("User with id " + id + " promoted to admin"); //debuggin
            }
        }
    }
}