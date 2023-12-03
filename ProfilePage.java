
// Display profile page and allows user to update their profile
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProfilePage extends JFrame implements ActionListener {
	private static final int LEFT_PADDING_SIZE = 10;

    JButton buttonUpdate;

    GridBagConstraints gbc = new GridBagConstraints();

    Font f = new Font("Verdana", Font.BOLD, 15);
    Font fLarge = new Font("Verdana", Font.BOLD, 16);

    JLabel profile_title = new JLabel("Profile Information");

    JLabel name = new JLabel("Nickname");
    JTextField tfName = new JTextField(20);

    JLabel email = new JLabel("Email");
    JTextField tfEmail = new JTextField(20);

    JLabel gender = new JLabel("Gender ");
    JComboBox<String> genderList = new JComboBox<>();

    JLabel ethnicity = new JLabel("Ethnicity");
    JTextField tfEthnicity = new JTextField(20);

    JLabel age = new JLabel("Age");
    JTextField tfAge = new JTextField(3);

    JLabel currProblems = new JLabel("Currently struggling with...");
    JTextField tfProblems = new JTextField(250);

    JLabel viewedGroups = new JLabel("Currently struggling with...");

    JPanel mainpanel = new JPanel();
    JScrollPane bar;
    User user;

    public ProfilePage() {}
    
    public ProfilePage(User r) {
    	
    	System.out.println("Profile Init");
        this.user = r;

        int i;

        for (i = 0; i < User.GENDER_LIST.length; i++) {
            genderList.addItem(User.GENDER_LIST[i]);
        }
        genderList.setSelectedItem("Other");

        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        buttonUpdate = new JButton();
        buttonUpdate.setSize(20, 15);
        buttonUpdate.setText("Update Profile");
        buttonUpdate.addActionListener(this);

        southPanel.add(buttonUpdate);
        southPanel.setBorder(new EmptyBorder(5, 0, 15, 0));

        mainpanel.setLayout(new BorderLayout(0, 15));
        mainpanel.setBorder(new EmptyBorder(30, 50, 0, 50));

        centerPanel.setLayout(new GridBagLayout());
        bar = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weightx = 0;
        gbc.weighty = 0;

        // Add components to centerPanel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(profile_title, gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(name, tfName), gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(email, tfEmail), gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(gender, genderList), gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(ethnicity, tfEthnicity), gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(age, tfAge), gbc);

        gbc.gridy++;
        centerPanel.add(createLabeledField(currProblems, tfProblems), gbc);

        gbc.gridy++;
        centerPanel.add(viewedGroups, gbc);

        mainpanel.add(bar, BorderLayout.CENTER);
        mainpanel.add(southPanel, BorderLayout.SOUTH);
    }

    private JPanel createLabeledField(JLabel label, JComponent component) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, LEFT_PADDING_SIZE, 0));
        label.setFont(fLarge);
        panel.add(label);
        component.setFont(f);
        panel.add(component);
        return panel;
    }

    public JComponent getContent() {
        return mainpanel;
    }

    public void updateUser() {
        // Implement this method to update the User object with the entered information
        user.setName(tfName.getText());
        user.setEmail(tfEmail.getText());
        user.setGender((String) genderList.getSelectedItem());
        user.setEthnicity(tfEthnicity.getText());
        // Continue updating other fields as needed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonUpdate) {
            updateUser();
            // Add any additional logic needed when the update button is clicked
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProfilePage(new User()).setVisible(true));
    }
}


