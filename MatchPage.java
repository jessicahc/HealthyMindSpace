import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MatchPage {

    private JPanel contentPanel;
    private MatchedProfilesTable matchedProfilesTable;

    public MatchPage(ArrayList<User> matchedUsers) {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        matchedProfilesTable = new MatchedProfilesTable(matchedUsers);
        JComponent component = matchedProfilesTable.getContent();

        JLabel titleLabel = new JLabel("Matched Profiles");
        titleLabel.setFont(MainGUI.FONT_SUBTITLE);

        contentPanel.add(BorderLayout.NORTH, titleLabel);
        contentPanel.add(BorderLayout.CENTER, component);
    }

    public JComponent getContent() {
        return contentPanel;
    }

    private static class MatchedProfilesTable {

        private JTable table;
        private MatchedProfilesTableModel tableModel;

        public MatchedProfilesTable(ArrayList<User> matchedUsers) {
            tableModel = new MatchedProfilesTableModel(matchedUsers);
            table = new JTable(tableModel);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
        }

        public JComponent getContent() {
            return new JScrollPane(table);
        }
    }

    private static class MatchedProfilesTableModel extends AbstractTableModel {

        private static final String[] COLUMN_NAMES = {"Name", "Age", "Gender", "Race", "Identity"};
        private ArrayList<User> data;

        public MatchedProfilesTableModel(ArrayList<User> data) {
            this.data = data;
        }

        public int getRowCount() {
            return data.size();
        }

        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            User user = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return user.getName();
                case 1:
                    return user.getAge();
                case 2:
                    return user.getGender();
                case 3:
                    return user.getRace();
                case 4:
                    return user.getIdentity();
                default:
                    return null;
            }
        }

        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }
    }
}
