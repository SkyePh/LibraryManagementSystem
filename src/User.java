public class User {

    private String name;
    private String password;
    private String id;
    private String role;

    public User(String name, String password, String id) {

        this.name = name;
        this.password = password;
        this.id = id;
        this.role = "USER"; //initially a user not an admin
    }

    //getters
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getId() {
        return id;
    }

    //TODO make pass a hash for security
    public String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    //role setter
    public void setRole(String role) {
        this.role = role;
    }
}
