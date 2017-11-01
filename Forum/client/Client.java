<<<<<<< HEAD
/*
The GUI
	-allows users to log into the server and view the forum
		-stores user log in for the session
		-can view a scrollable list of user created threads
			-each thread shows as a title, which indicates the topic
			-over a certain limit, the list of threads is divided over multiple pages
				-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
			-clicking on a thread displays a list of all posts in the thread
				-over a certain limit, the list of posts are divided over multiple pages
					-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
				-users can create a new post in a thread, which is appended to the end of the list

	
*/
package client;

import forum.Forum;
import forum.Thread;
import forum.Post;

import static server.Time.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Client implements ActionListener {
	private JButton backButton = new JButton("Return");
	private JButton refreshButton = new JButton("Refresh");
	private JButton previousPageButton = new JButton("<");
	private JButton nextPageButton = new JButton(">");
	private JButton jumpToPageButton = new JButton("Go");
	private JButton submitButton = new JButton("Submit");

	private JScrollPane displayScrollPane;
	private JScrollPane messageScrollPane;

	private JPanel responsePanel = new JPanel(new GridBagLayout());
	private JPanel navigationPanel = new JPanel(new GridBagLayout());
	private JPanel displayPanel = new JPanel(new GridBagLayout());
	private JPanel tabPanel = new JPanel(new GridBagLayout());

	private JLabel usernameLabel = new JLabel("Insert Username");
	private JLabel pageLabel = new JLabel("Page X of Y");

	private JTextField pageField = new JTextField(4);
	private JTextField subjectField = new JTextField("Subject",30);
	private JTextArea messageArea = new JTextArea("Message body", 5, 30);

	private JTabbedPane forumTab = new JTabbedPane();

	private final GridBagConstraints gbc = new GridBagConstraints();

	private Forum forum = new Forum();
	private Thread currentThread;
	private static java.util.List<JPanel> panelList = new java.util.ArrayList<JPanel>();


	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == submitButton) {
			if(currentThread == null) {
				forum.createThread(subjectField.getText(), usernameLabel.getText(), getFormattedDate(), getFormattedTime(), messageArea.getText());
				refreshForum();
			}
			else {
				forum.createPost(currentThread, usernameLabel.getText(), getFormattedDate(), getFormattedTime(), messageArea.getText());
				refreshThread();
			}
		}
		if(a.getSource() == backButton) {
			subjectField.setText("Null");
			currentThread = null;
		}
	}

	public void initializeNavigationPanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		backButton.addActionListener(this);

		navigationPanel.add(usernameLabel, gbc);
		gbc.gridx++;
		navigationPanel.add(backButton, gbc);
		gbc.gridx++;
		navigationPanel.add(refreshButton, gbc);
		gbc.gridx++;
		navigationPanel.add(pageLabel, gbc);
		gbc.gridx++;
		navigationPanel.add(previousPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(pageField, gbc);
		gbc.gridx++;
		navigationPanel.add(jumpToPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(nextPageButton, gbc);
	}

	public void initializeResponsePanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;

		messageArea.setLineWrap(true);
		messageScrollPane = new JScrollPane(messageArea);

		submitButton.addActionListener(this);

		responsePanel.add(submitButton, gbc);
		gbc.gridx++;
		responsePanel.add(messageScrollPane, gbc);
		gbc.gridy--;
		responsePanel.add(subjectField, gbc);
	}

	public JPanel formatThreads(Thread thread, int index) {
		JPanel panel = new JPanel();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = index;

		panel.add(new JLabel("Subject: " + thread.getSubject()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Username: " + thread.getUsername()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Date: " + thread.getDate()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Time: " + thread.getTime()), gbc);

		panel.addMouseListener(
			new MouseListener() {
				public void mouseReleased(MouseEvent event) {}
				public void mousePressed(MouseEvent event) {}
				public void mouseExited(MouseEvent event) {}
				public void mouseEntered(MouseEvent event) {}
				public void mouseClicked(MouseEvent event) {
					int index = 0;
					for(JPanel panel : panelList) {
						if(panel == event.getSource()) {
							currentThread = forum.getForum().get(index);
							subjectField.setText(currentThread.getSubject());
							messageArea.setText(currentThread.getSubject());
							refreshThread();
						}
						index++;
					}
				}
			}
		);

		return panel;
	}

	public JPanel formatPosts(Post post, int index) {
		JPanel panel = new JPanel();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = index;

		panel.add(new JLabel("Message: " + post.getMessage()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Username: " + post.getUsername()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Date: " + post.getDate()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Time: " + post.getTime()), gbc);

		return panel;
	}

	public void populateThreadList() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		panelList.clear();

		int index = 0;
		for(Thread thread : forum.getForum()) {
			panelList.add(formatThreads(thread, index));
			displayPanel.add(panelList.get(index), gbc);
			gbc.gridy++;
			index++;
		}

		displayPanel.setPreferredSize(new Dimension(500,300));
	}

	public void populatePostList() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		panelList.clear();

		int index = 0;
		for(Thread thread : forum.getForum()) {
			for(Post post : thread.getThread()) {
				panelList.add(formatPosts(post, index));
				displayPanel.add(panelList.get(index), gbc);
				gbc.gridy++;
				index++;
			}
		}
	}

	public void initializeForum() {
		populateThreadList();
		initializeResponsePanel();
		initializeNavigationPanel();
		formatScrollPane();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		tabPanel.add(navigationPanel, gbc);
		gbc.gridy++;
		tabPanel.add(displayScrollPane, gbc);
		gbc.gridy++;
		tabPanel.add(responsePanel, gbc);
		forumTab.add("Forum", tabPanel);
	}

	public void formatScrollPane() {
		displayScrollPane = new JScrollPane(displayPanel);
		displayScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		displayScrollPane.setViewportView(displayPanel);
		displayScrollPane.setPreferredSize(new Dimension(600, 400));
	}

	public void refreshForum() {
		populateThreadList();
//		formatScrollPane();

		gbc.gridx = 0;
		gbc.gridy = 1;

		tabPanel.add(displayScrollPane, gbc);

		forumTab.revalidate();
		forumTab.repaint();
	}

	public void refreshThread() {
		populatePostList();
		formatScrollPane();

		gbc.gridx = 0;
		gbc.gridy = 1;

		tabPanel.add(displayScrollPane, gbc);

		forumTab.revalidate();
		forumTab.repaint();
	}
	//public void initializeForum() {}
	//public void displayThread() {}

	public Client() {
		initializeForum();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		JFrame frame = new JFrame("Fitness Journal");
		frame.setLayout(new GridBagLayout());
		frame.add(forumTab, gbc);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String args[]) {
		Client test = new Client();
	}

=======
/*
The GUI
	-allows users to log into the server and view the forum
		-stores user log in for the session
		-can view a scrollable list of user created threads
			-each thread shows as a title, which indicates the topic
			-over a certain limit, the list of threads is divided over multiple pages
				-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
			-clicking on a thread displays a list of all posts in the thread
				-over a certain limit, the list of posts are divided over multiple pages
					-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
				-users can create a new post in a thread, which is appended to the end of the list

	
*/
package client;

import forum.Forum;
import forum.Thread;
import forum.Post;

import static server.Time.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;


public class Client implements ActionListener {
	private JButton backButton = new JButton("Return");
	private JButton refreshButton = new JButton("Refresh");
	private JButton previousPageButton = new JButton("<");
	private JButton nextPageButton = new JButton(">");
	private JButton jumpToPageButton = new JButton("Go");
	private JButton submitButton = new JButton("Submit");

	private JScrollPane displayScrollPane;
	private JScrollPane messageScrollPane;

	private JPanel responsePanel = new JPanel(new GridBagLayout());
	private JPanel navigationPanel = new JPanel(new GridBagLayout());
	private JPanel displayPanel = new JPanel(new GridBagLayout());
	private JPanel tabPanel = new JPanel(new GridBagLayout());

	private JLabel usernameLabel = new JLabel("Insert Username");
	private JLabel pageLabel = new JLabel("Page X of Y");

	private JTextField pageField = new JTextField(4);
	private JTextField subjectField = new JTextField("Subject",30);
	private JTextArea messageArea = new JTextArea("Message body", 5, 30);

	private JTabbedPane forumTab = new JTabbedPane();

	private final GridBagConstraints gbc = new GridBagConstraints();

	private Forum forum = new Forum();
	private Thread currentThread;
	private static java.util.List<JPanel> panelList = new java.util.ArrayList<JPanel>();


	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == submitButton) {
			if(currentThread == null) {
				forum.createThread(subjectField.getText(), usernameLabel.getText(), getFormattedDate(), getFormattedTime(), messageArea.getText());
				refreshForum();
			}
			else {
				forum.createPost(currentThread, usernameLabel.getText(), getFormattedDate(), getFormattedTime(), messageArea.getText());
				refreshThread();
			}
		}
		if(a.getSource() == backButton) {
			subjectField.setText("Null");
			currentThread = null;
		}
	}

	public void initializeNavigationPanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		backButton.addActionListener(this);

		navigationPanel.add(usernameLabel, gbc);
		gbc.gridx++;
		navigationPanel.add(backButton, gbc);
		gbc.gridx++;
		navigationPanel.add(refreshButton, gbc);
		gbc.gridx++;
		navigationPanel.add(pageLabel, gbc);
		gbc.gridx++;
		navigationPanel.add(previousPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(pageField, gbc);
		gbc.gridx++;
		navigationPanel.add(jumpToPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(nextPageButton, gbc);
	}

	public void initializeResponsePanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;

		messageArea.setLineWrap(true);
		messageScrollPane = new JScrollPane(messageArea);

		submitButton.addActionListener(this);

		responsePanel.add(submitButton, gbc);
		gbc.gridx++;
		responsePanel.add(messageScrollPane, gbc);
		gbc.gridy--;
		responsePanel.add(subjectField, gbc);
	}

	public JPanel formatThreads(Thread thread, int index) {
		JPanel panel = new JPanel();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = index;

		panel.add(new JLabel("Subject: " + thread.getSubject()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Username: " + thread.getUsername()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Date: " + thread.getDate()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Time: " + thread.getTime()), gbc);

		panel.addMouseListener(
			new MouseListener() {
				public void mouseReleased(MouseEvent event) {}
				public void mousePressed(MouseEvent event) {}
				public void mouseExited(MouseEvent event) {}
				public void mouseEntered(MouseEvent event) {}
				public void mouseClicked(MouseEvent event) {
					int index = 0;
					for(JPanel panel : panelList) {
						if(panel == event.getSource()) {
							currentThread = forum.getForum().get(index);
							subjectField.setText(currentThread.getSubject());
							messageArea.setText(currentThread.getSubject());
							refreshThread();
						}
						index++;
					}
				}
			}
		);

		return panel;
	}

	public JPanel formatPosts(Post post, int index) {
		JPanel panel = new JPanel();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = index;

		panel.add(new JLabel("Message: " + post.getMessage()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Username: " + post.getUsername()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Date: " + post.getDate()), gbc);
		gbc.gridy++;
		panel.add(new JLabel("Time: " + post.getTime()), gbc);

		return panel;
	}

	public void populateThreadList() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		panelList.clear();

		int index = 0;
		for(Thread thread : forum.getForum()) {
			panelList.add(formatThreads(thread, index));
			displayPanel.add(panelList.get(index), gbc);
			gbc.gridy++;
			index++;
		}

		displayPanel.setPreferredSize(new Dimension(500,300));
	}

	public void populatePostList() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		panelList.clear();

		int index = 0;
		for(Thread thread : forum.getForum()) {
			for(Post post : thread.getThread()) {
				panelList.add(formatPosts(post, index));
				displayPanel.add(panelList.get(index), gbc);
				gbc.gridy++;
				index++;
			}
		}
	}

	public void initializeForum() {
		populateThreadList();
		initializeResponsePanel();
		initializeNavigationPanel();
		formatScrollPane();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		tabPanel.add(navigationPanel, gbc);
		gbc.gridy++;
		tabPanel.add(displayScrollPane, gbc);
		gbc.gridy++;
		tabPanel.add(responsePanel, gbc);
		forumTab.add("Forum", tabPanel);
	}

	public void formatScrollPane() {
		displayScrollPane = new JScrollPane(displayPanel);
		displayScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		displayScrollPane.setViewportView(displayPanel);
		displayScrollPane.setPreferredSize(new Dimension(600, 400));
	}

	public void refreshForum() {
		populateThreadList();
//		formatScrollPane();

		gbc.gridx = 0;
		gbc.gridy = 1;

		tabPanel.add(displayScrollPane, gbc);

		forumTab.revalidate();
		forumTab.repaint();
	}

	public void refreshThread() {
		populatePostList();
		formatScrollPane();

		gbc.gridx = 0;
		gbc.gridy = 1;

		tabPanel.add(displayScrollPane, gbc);

		forumTab.revalidate();
		forumTab.repaint();
	}
	//public void initializeForum() {}
	//public void displayThread() {}

	public Client() {
		initializeForum();

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		JFrame frame = new JFrame("Fitness Journal");
		frame.setLayout(new GridBagLayout());
		frame.add(forumTab, gbc);
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	public static void main(String args[]) {
		Client test = new Client();
	}

>>>>>>> d668070edece6b6733ef33dc1935fb274d3261df
}