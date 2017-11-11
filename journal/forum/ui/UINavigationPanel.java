package forum.ui;

import javax.swing.*;
import java.awt.*;

public class UINavigationPanel extends JPanel {
    private JButton backButton = new JButton("Return");
    private JButton refreshButton = new JButton("Refresh");
    private JButton previousPageButton = new JButton("<");
    private JButton nextPageButton = new JButton(">");
    private JButton jumpToPageButton = new JButton("Go");

    private JLabel usernameLabel = new JLabel("Insert Username");
    private JLabel pageLabel = new JLabel("Page X of Y");

    private JTextField pageField = new JTextField(4);

    public JButton getBackButton() {return backButton;}
    public JButton getRefreshButton() {return refreshButton;}
    public JButton getPreviousPageButton() {return previousPageButton;}
    public JButton getNextPageButton() {return nextPageButton;}
    public JButton getJumpToPageButton() {return jumpToPageButton;}

    public int getPageToJump() {
        return Integer.parseInt(pageField.getText());
    }
    public String getUsername() {return usernameLabel.getText();}

    public void setUsernameLabel(String username) {
        usernameLabel.setText(username);
    }
    public void setPageLabel(int currentPage, int totalPages) {pageLabel.setText("Page " + Integer.toString(currentPage) + " of " + Integer.toString(totalPages));}

    public UINavigationPanel(String username) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        usernameLabel.setText(username);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;

        add(usernameLabel, gbc);
        gbc.gridx++;
        add(backButton, gbc);
        gbc.gridx++;
        add(refreshButton, gbc);
        gbc.gridx++;
        add(pageLabel, gbc);
        gbc.gridx++;
        add(previousPageButton, gbc);
        gbc.gridx++;
        add(pageField, gbc);
        gbc.gridx++;
        add(jumpToPageButton, gbc);
        gbc.gridx++;
        add(nextPageButton, gbc);
    }
}
