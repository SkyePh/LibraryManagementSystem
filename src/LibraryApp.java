//this is a project to learn java. Its a library manegement system
//when i wrote this only god and i knew how it worked
//now, only god knows. Good Luck!

import javax.swing.*; //swing lib
//to add actionlisteners on the buttons and whatnot
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryApp {

    //add usermanager
    public static UserManager userManager = new UserManager();

    //add bookmanager
    public static BookManager bookManager = new BookManager();

    public static void main(String[] args) {

        //create the gui window
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close operation

        //add component on the window
        JPanel panel = new JPanel(); //a panel can hold components

        //we have to add the panel on the frame like pack on tkinter
        frame.add(panel);

        welcomeScreen(panel);

        frame.setVisible(true); // make the window visible
    }

    //welcome screen
    private static void welcomeScreen(JPanel panel) {

        panel.removeAll(); //clear screen

        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Library Management System");
        titleLabel.setBounds(100, 10, 180, 25);
        panel.add(titleLabel);

        JButton loginScreenButton = new JButton("Login");
        loginScreenButton.setBounds(120, 60, 120, 25);
        panel.add(loginScreenButton);

        JButton registerScreenButton = new JButton("Register");
        registerScreenButton.setBounds(120, 120, 120, 25);
        panel.add(registerScreenButton);

        loginScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginComponents(panel); //call login screen
            }
        });

        registerScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register ");
                registerComponents(panel); //call register screen
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }

    //login screen
    public static void loginComponents(JPanel panel) {

        panel.removeAll(); //clear existing comps

        //if we said the layout to numb we can manually add stuff
        panel.setLayout(null);

        //create the user label
        JLabel userLabel = new JLabel("User ID");
        userLabel.setBounds(10, 20, 80, 25); //pos and size
        panel.add(userLabel);

        //create text field
        JTextField userText = new JTextField(20);
        userText.setBounds(70, 20, 120, 25);
        panel.add(userText);

        //pass label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        //create pass fielf
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(70, 50, 120, 25);
        panel.add(passwordText);

        //create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 80, 25);
        panel.add(loginButton);

        //return to title
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(10, 130, 80, 25);
        panel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeScreen(panel);
            }
        });

        //add listener to loginButton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //display msg when btn is clicked
                String userid = userText.getText();
                String pass = passwordText.getText();

                userManager.authenticateUser(userid, pass, panel);
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components

    }

    public static void registerComponents(JPanel panel) {

        panel.removeAll(); //clear existing comps

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(70, 20, 180, 25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("User ID");
        idLabel.setBounds(10, 50, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(70, 50, 180, 25);
        panel.add(idText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(70, 80, 180, 25);
        panel.add(passwordText);

        JLabel password2Label = new JLabel("Confirm");
        password2Label.setBounds(10, 110, 80, 25);
        panel.add(password2Label);

        JPasswordField password2Text = new JPasswordField(20);
        password2Text.setBounds(70, 110, 180, 25);
        panel.add(password2Text);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 150, 160, 25);
        panel.add(registerButton);

        //return to main screen
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(10, 180, 160, 25);
        panel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeScreen(panel);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String id = idText.getText();
                String pass = passwordText.getText();
                String confirm = password2Text.getText();
                int passLength = pass.length();


                //constraints for pass creation
                if ((pass.isEmpty() && (confirm.isEmpty()))) {
                    System.out.println("Empty password");
                }
                else if (passLength < 6) {
                    System.out.println("Password too short");
                }
                else if (!pass.equals(confirm)) {
                    System.out.println("Passwords do not match");
                }
                else {
                    userManager.registerUser(name, pass, id); //successful registration
                    loginComponents(panel);
                }
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components

    }

    //if user logs in as admin
    public static void adminPanel (JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        //TODO make the panel

        JLabel titleAdmin = new JLabel("Admin Panel");
        titleAdmin.setBounds(10, 20, 80, 25);
        panel.add(titleAdmin);

        //add book
        JButton addButton = new JButton("Add Book");
        addButton.setBounds(10, 50, 150, 25);
        panel.add(addButton);

        //remove book
        JButton removeButton = new JButton("Remove Book");
        removeButton.setBounds(10, 90, 150, 25);
        panel.add(removeButton);

        //edit book
        JButton editButton = new JButton("Edit Book (not ready)");
        editButton.setBounds(10, 130, 150, 25);
        panel.add(editButton);

        //create a new admin acc for someone
        JButton newAdminButton = new JButton("New Admin");
        newAdminButton.setBounds(10, 170, 150, 25);
        panel.add(newAdminButton);

        //listener for add book btn
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookPanel(panel);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBookPanel(panel);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBookPanel(panel);
            }
        });

        newAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAdminRegister(panel);
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }

    //if user logs in as admin
    public static void userPanel (JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        JLabel titleUser = new JLabel("Successfully Logged in");
        titleUser.setBounds(10, 20, 150, 25);
        panel.add(titleUser);

        JLabel titleLabel = new JLabel("Book Title");
        titleLabel.setBounds(10, 50, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(70, 20, 180, 25);
        panel.add(titleText);

        JButton searchButton = new JButton("Search Book");
        searchButton.setBounds(10, 90, 150, 25);
        panel.add(searchButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(10, 130, 150, 25);
        panel.add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeScreen(panel);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleText.getText();

                bookManager.searchByTitle(title);
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }

    public static void newAdminRegister(JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        JTextField nameText = new JTextField(20);
        nameText.setBounds(70, 20, 180, 25);
        panel.add(nameText);

        JLabel idLabel = new JLabel("User ID");
        idLabel.setBounds(10, 50, 80, 25);
        panel.add(idLabel);

        JTextField idText = new JTextField(20);
        idText.setBounds(70, 50, 180, 25);
        panel.add(idText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(70, 80, 180, 25);
        panel.add(passwordText);

        JLabel password2Label = new JLabel("Confirm");
        password2Label.setBounds(10, 110, 80, 25);
        panel.add(password2Label);

        JPasswordField password2Text = new JPasswordField(20);
        password2Text.setBounds(70, 110, 180, 25);
        panel.add(password2Text);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 150, 160, 25);
        panel.add(registerButton);

        //return to main screen
        JButton returnButton = new JButton("Return");
        returnButton.setBounds(10, 180, 160, 25);
        panel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomeScreen(panel);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String id = idText.getText();
                String pass = passwordText.getText();
                String confirm = password2Text.getText();
                int passLength = pass.length();


                //constraints for pass creation
                if ((pass.isEmpty() && (confirm.isEmpty()))) {
                    System.out.println("Empty password");
                }
                else if (passLength < 6) {
                    System.out.println("Password too short");
                }
                else if (!pass.equals(confirm)) {
                    System.out.println("Passwords do not match");
                }
                else {
                    userManager.registerAdmin(name, pass, id); //successful registration
                    adminPanel(panel);
                }
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components

    }

    //add book panel
    public static void addBookPanel (JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(70, 20, 180, 25);
        panel.add(titleText);

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(10, 50, 80, 25);
        panel.add(authorLabel);

        JTextField authorText = new JTextField(20);
        authorText.setBounds(70, 50, 180, 25);
        panel.add(authorText);

        JLabel publisherLabel = new JLabel("Publisher");
        publisherLabel.setBounds(10, 80, 80, 25);
        panel.add(publisherLabel);

        JTextField publisherText = new JTextField(20);
        publisherText.setBounds(70, 80, 180, 25);
        panel.add(publisherText);

        JLabel isbnLabel = new JLabel("ISBN");
        isbnLabel.setBounds(10, 110, 80, 25);
        panel.add(isbnLabel);

        JTextField isbnText = new JTextField(20);
        isbnText.setBounds(70, 110, 180, 25);
        panel.add(isbnText);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(10, 170, 150, 25);
        panel.add(addButton);

        JButton returnButton = new JButton("Cancel");
        returnButton.setBounds(10, 210, 160, 25);
        panel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               adminPanel(panel);
           }
        });

        addButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String title = titleText.getText();
               String author = authorText.getText();
               String publisher = publisherText.getText();
               String isbn = isbnText.getText();

               if ((title.isEmpty()) || (author.isEmpty()) || (publisher.isEmpty()) || (isbn.isEmpty())) {
                   System.out.println("Empty title");
               }
               else {
                   bookManager.addBook(title, author, publisher, isbn);
               }
           }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }

    public static void removeBookPanel (JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        JLabel isbnLabel = new JLabel("ISBN");
        isbnLabel.setBounds(10, 110, 80, 25);
        panel.add(isbnLabel);

        JTextField isbnText = new JTextField(20);
        isbnText.setBounds(70, 110, 180, 25);
        panel.add(isbnText);

        JButton removeButton = new JButton("Remove");
        removeButton.setBounds(10, 170, 150, 25);
        panel.add(removeButton);

        JButton returnButton = new JButton("Cancel");
        returnButton.setBounds(10, 210, 160, 25);
        panel.add(returnButton);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel(panel);
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookManager.removeBook(isbnText.getText());
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }

    public static void editBookPanel (JPanel panel) {
        panel.removeAll();

        panel.setLayout(null);

        //find the book to edit
        JLabel isbnLabel = new JLabel("ISBN");
        isbnLabel.setBounds(10, 20, 80, 25);
        panel.add(isbnLabel);

        JTextField isbnText = new JTextField(20);
        isbnText.setBounds(40, 20, 180, 25);
        panel.add(isbnText);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(10, 210, 160, 25);
        panel.add(returnButton);

        //TODO implement this feature

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminPanel(panel);
            }
        });

        panel.revalidate(); // Revalidate the panel
        panel.repaint(); // Repaint the panel to show new components
    }
}
