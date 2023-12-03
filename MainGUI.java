import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MainGUI implements ActionListener {

    public static Font FONT_BIG_TITLE = new Font("Verdana", Font.BOLD, 24);
    public static Font FONT_BUTTON = new Font("Verdana", Font.PLAIN, 15);
    public static Font FONT_CONTENT = new Font("Verdana", Font.BOLD, 15);
    public static Color BGCOLOR_LIGHTBLUE = new Color(159, 206, 249);

    JFrame mainFrame;
    JPanel menuPanel;
    JPanel mainPanel;

    JLabel lblMainTitle;
    JButton btnHome;
    JButton btnCommunity;
    JButton btnEvents;
    JButton btnProfile;

    ProfilePage profilePage;

    public MainGUI() {
        mainFrame = new JFrame();

        menuPanel = new JPanel();
        mainPanel = new JPanel();

        lblMainTitle = new JLabel("Mental Health App");

        btnHome = new JButton("Home");
        btnHome.addActionListener(this);

        btnCommunity = new JButton("Communities");
        btnCommunity.addActionListener(this);

        btnEvents = new JButton("Events");
        btnEvents.addActionListener(this);

        btnProfile = new JButton("My Profile");
        btnProfile.addActionListener(this);

    }

    public void initialize() {
        mainFrame.setSize(300, 900);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainFrame.setLocationRelativeTo(null); // doesn't work on Mac

        // Title and logo section
        // ImageIcon logoIcon = new ImageIcon("logo_sm.png");
        JLabel lblLogo = new JLabel();
        // lblMainTitle.setIcon(logoIcon);
        lblMainTitle.setFont(FONT_BIG_TITLE);
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(BGCOLOR_LIGHTBLUE);
        panelTitle.add(lblLogo);
        panelTitle.add(new JLabel("   ")); // add extra gap
        panelTitle.add(lblMainTitle);

        // Group title panel and buttons together in menuPanel
        menuPanel.setBackground(BGCOLOR_LIGHTBLUE);
        menuPanel.setBorder(new EmptyBorder(20, 40, 10, 40));

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        menuPanel.setLayout(gb);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.weightx = 0;
        c.weighty = 0;
        menuPanel.add(panelTitle, c);

        c.insets = new Insets(10, 0, 20, 10);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.ipady = 5;
        menuPanel.add(btnHome, c);
        // c.insets = new Insets(10, 10, 20, 10);
        c.gridx = 1;
        // c.gridy = 5;
        // c.gridwidth = 1;
        // c.ipady = 5;
        menuPanel.add(btnCommunity, c);
        // c.insets = new Insets(10, 10, 20, 10);
        c.gridx = 2;
        // c.gridy = 5;
        // c.gridwidth = 1;
        // c.ipady = 5;
        menuPanel.add(btnEvents, c);
        // c.insets = new Insets(10, 10, 20, 0);
        c.gridx = 3;
        // c.gridy = 5;
        // c.gridwidth = 1;
        // c.ipady = 5;
        menuPanel.add(btnProfile, c);

        // Main content section
        mainPanel.setBackground(BGCOLOR_LIGHTBLUE);
        mainPanel.setLayout(new BorderLayout(0, 10)); // set gap between the caption and the content form/table
        mainPanel.setPreferredSize(new Dimension(780, 400));
        mainPanel.setBorder(new EmptyBorder(0, 30, 20, 30));

        // Place menuPanel and mainPanel vertically in the frame's contentPane
        Container contentPane = mainFrame.getContentPane();
        contentPane.setBackground(BGCOLOR_LIGHTBLUE);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(BorderLayout.NORTH, menuPanel);
        contentPane.add(BorderLayout.CENTER, mainPanel);
    }

    public void displayFrame() {
        // displayViewActiveReservations();
        btnHome.setForeground(Color.BLUE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    protected void displayProfilePage() {
    	mainPanel.removeAll();

//    	profilePage = new ProfilePage();
//    	JComponent component = profilePage.getContent();
    	// content panel
    	JLabel tmpLabel = new JLabel("Profile page will be displayed here");

    	JLabel lblMyProfile = new JLabel("My Profile");
    	lblMyProfile.setFont(FONT_CONTENT);
    	mainPanel.add(BorderLayout.NORTH, lblMyProfile);
    	mainPanel.add(BorderLayout.CENTER, tmpLabel);

    	mainPanel.validate();
    	mainPanel.repaint();
    }

    // protected void displayViewModifyReservation(ActionEvent e) {
    // if (lastSelectedReservation != null)
    // viewReservationForm = new ViewReservation(lastSelectedReservation);
    // else {
    // JOptionPane.showMessageDialog(mainFrame, "No Reservation Selected! Please
    // select a reservation first.",
    // "ERROR", JOptionPane.ERROR_MESSAGE);
    // return;
    // }

    // mainPanel.removeAll();
    // viewReservationForm = new ViewReservation(lastSelectedReservation);
    // JComponent component = viewReservationForm.getContent();

    // JLabel lblNewRes = new JLabel(" View or Modify a Reserveration:");
    // lblNewRes.setFont(FONT_CONTENT);
    // mainPanel.add(BorderLayout.NORTH, lblNewRes);
    // mainPanel.add(BorderLayout.CENTER, component);

    // mainPanel.validate();
    // mainPanel.repaint();
    // }

    // protected void displayViewActiveReservations() {
    // mainPanel.removeAll();

    // activeReservationsTable = new ActiveReservationsTable(this);

    // JComponent component = activeReservationsTable.getContent();
    // JLabel lblActiveRes = new JLabel(" Active / Upcoming Reserverations:");
    // lblActiveRes.setFont(FONT_CONTENT);
    // mainPanel.add(BorderLayout.NORTH, lblActiveRes);
    // mainPanel.add(BorderLayout.CENTER, component);

    // mainPanel.validate();
    // mainPanel.repaint();

    // }

    // protected void displayViewInactiveReservations() {
    // mainPanel.removeAll();

    // inactiveReservationsTable = new InactiveReservationsTable(this);

    // JComponent component = inactiveReservationsTable.getContent();
    // JLabel lblInactiveRes = new JLabel(" Inactive Reserverations:");
    // lblInactiveRes.setFont(FONT_CONTENT);
    // mainPanel.add(BorderLayout.NORTH, lblInactiveRes);
    // mainPanel.add(BorderLayout.CENTER, component);

    // mainPanel.validate();
    // mainPanel.repaint();

    // }

     public void actionPerformed(ActionEvent e) {
     String cmd = e.getActionCommand();

     if (cmd.equalsIgnoreCase(btnProfile.getText())) {
    	 System.out.println("Profile is clicked");
    	 displayProfilePage();
     }
    // else if (cmd.equalsIgnoreCase(btnViewModifyRes.getText())) {
    // System.out.println("ViewModifyAReservation is clicked");
    // displayViewModifyReservation(e);
    // }
    // else if (cmd.equalsIgnoreCase(btnViewActiveRes.getText())) {
    // System.out.println("ViewActiveReservations is clicked");
    // displayViewActiveReservations();
    // }
    // else if (cmd.equalsIgnoreCase(btnViewInactiveRes.getText())) {
    // System.out.println("ViewInactiveReservations is clicked");
    // displayViewInactiveReservations();
    // }
    // else if (cmd.equalsIgnoreCase("ActiveReservationsTable")) {
    // this.lastSelectedReservation =
    // activeReservationsTable.getSelectedReservation();
    // System.out.println("MainGUI: update lastSelectedReservation = "
    // + ((lastSelectedReservation != null) ?
    // lastSelectedReservation.getReservationId() : "null"));
    // }
    // else if (cmd.equalsIgnoreCase("InactiveReservationsTable")) {
    // this.lastSelectedReservation =
    // inactiveReservationsTable.getSelectedReservation();
    // System.out.println("MainGUI: update lastSelectedReservation = "
    // + ((lastSelectedReservation != null) ?
    // lastSelectedReservation.getReservationId() : "null"));
    // }
     }

    public static void main(String[] args) {
        // ReservationFileHandler.loadReservations("Reservations2022.txt");
        MainGUI base = new MainGUI();
        base.initialize();
        base.displayFrame();
    }

}