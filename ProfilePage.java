
// Display profile page and allows user to update their profile
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage extends JFrame {
    private JTextField nameField, emailField, genderField, raceField, ageField, identityField, resourcesField,
            problemsField, groupsField;

    public ProfilePage() {
        initializeComponents();
        setLayout();
        setListeners();
    }

    private void initializeComponents() {
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        genderField = new JTextField(20);
        raceField = new JTextField(20);
        ageField = new JTextField(20);
        identityField = new JTextField(20);
        resourcesField = new JTextField(20);
        problemsField = new JTextField(20);
        groupsField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        JButton editButton = new JButton("Edit");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Gender:"));
        panel.add(genderField);
        panel.add(new JLabel("Race:"));
        panel.add(raceField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Identity:"));
        panel.add(identityField);
        panel.add(new JLabel("Resources:"));
        panel.add(resourcesField);
        panel.add(new JLabel("Current Problems:"));
        panel.add(problemsField);
        panel.add(new JLabel("Viewed Groups:"));
        panel.add(groupsField);
        panel.add(saveButton);
        panel.add(editButton);

        add(panel);
    }

    private void setLayout() {
        setTitle("Profile Page");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void setListeners() {
        // Add action listener for the "Edit" button
        // This listener enables editing of fields
        JButton editButton = findButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableEditing(true);
            }
        });

        // Add action listener for the "Save" button
        // This listener saves the changes and disables editing
        JButton saveButton = findButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveChanges();
                enableEditing(false);
            }
        });
    }

    private void enableEditing(boolean enable) {
        nameField.setEditable(enable);
        emailField.setEditable(enable);
        genderField.setEditable(enable);
        raceField.setEditable(enable);
        ageField.setEditable(enable);
        identityField.setEditable(enable);
        resourcesField.setEditable(enable);
        problemsField.setEditable(enable);
        groupsField.setEditable(enable);
    }

    private void saveChanges() {
        // Implement the logic to save changes to the UserProfile object
        // For simplicity, we'll just print the values for now
        System.out.println("Name: " + nameField.getText());
        System.out.println("Email: " + emailField.getText());
        System.out.println("Gender: " + genderField.getText());
        System.out.println("Race: " + raceField.getText());
        System.out.println("Age: " + ageField.getText());
        System.out.println("Identity: " + identityField.getText());
        System.out.println("Resources: " + resourcesField.getText());
        System.out.println("Current Problems: " + problemsField.getText());
        System.out.println("Viewed Groups: " + groupsField.getText());
    }

    private JButton findButton(String buttonText) {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton && ((JButton) component).getText().equals(buttonText)) {
                return (JButton) component;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProfilePage().setVisible(true);
            }
        });
    }
}
