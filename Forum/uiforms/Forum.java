<<<<<<< HEAD
package uiforms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forum {
    private JTabbedPane forumTab;
    private JButton backButton;
    private JButton refreshButton;
    private JButton previousPageButton;
    private JTextField pageNumberField;
    private JButton jumpToPageButton;
    private JButton nextPageButton;
    private JButton submitButton;
    private JTextArea messageArea;
    private JTextField subjectField;
    private JList forum;
    private JPanel forumPanel;
    private JPanel navigationPanel;
    private JLabel usernameLabel;
    private JPanel responsePanel;
    private JScrollPane forumScrollPane;
    private JScrollPane messageScrollPane;

    public Forum() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jumpToPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fitness Journal");
        frame.setLayout(new GridLayout());
        frame.setContentPane(new Forum().forumTab);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

}
=======
package uiforms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Forum {
    private JTabbedPane forumTab;
    private JButton backButton;
    private JButton refreshButton;
    private JButton previousPageButton;
    private JTextField pageNumberField;
    private JButton jumpToPageButton;
    private JButton nextPageButton;
    private JButton submitButton;
    private JTextArea messageArea;
    private JTextField subjectField;
    private JList forum;
    private JPanel forumPanel;
    private JPanel navigationPanel;
    private JLabel usernameLabel;
    private JPanel responsePanel;
    private JScrollPane forumScrollPane;
    private JScrollPane messageScrollPane;

    public Forum() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        jumpToPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fitness Journal");
        frame.setLayout(new GridLayout());
        frame.setContentPane(new Forum().forumTab);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }

}
>>>>>>> d668070edece6b6733ef33dc1935fb274d3261df
