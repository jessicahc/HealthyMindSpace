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
    JButton btnMatch;
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

        btnMatch = new JButton("Match");
        btnMatch.addActionListener(this);
        
        btnEvents = new JButton("Events");
        btnEvents.addActionListener(this);

        btnProfile = new JButton("My Profile");
        btnProfile.addActionListener(this);

    }

    public void initialize() {
        mainFrame.setSize(300, 900);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
  
        c.gridx = 1; 
        menuPanel.add(btnCommunity, c);
       
        c.gridx = 2;
        menuPanel.add(btnMatch, c);
   
        c.gridx = 3;
        menuPanel.add(btnEvents, c);
        
        c.gridx = 4;
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

    	profilePage = new ProfilePage();
    	JComponent component = profilePage.getContent();
    	// content panel
    	JLabel tmpLabel = new JLabel("Profile page will be displayed here");

    	JLabel lblMyProfile = new JLabel("My Profile");
    	lblMyProfile.setFont(FONT_CONTENT);
    	mainPanel.add(BorderLayout.NORTH, lblMyProfile);
    	mainPanel.add(BorderLayout.CENTER, tmpLabel);

    	mainPanel.validate();
    	mainPanel.repaint();
    }


     public void actionPerformed(ActionEvent e) {
    	 String cmd = e.getActionCommand();

    	 if (cmd.equalsIgnoreCase(btnProfile.getText())) {
    		 System.out.println("Profile is clicked");
    		 displayProfilePage();
    	 }

     }

    public static void main(String[] args) {
        // UserFileHandler.loadUser("Users.txt");
        MainGUI base = new MainGUI();
        base.initialize();
        base.displayFrame();
    }

}