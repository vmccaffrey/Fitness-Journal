/*
The GUI
	-allows users to log into the forum server and view the forum
		-stores user log in for the session
		-can view a scrollable list of user created threads
			-each thread shows as a title, which indicates the topic
			-over a certain limit, the list of threads is divided over multiple pages
				-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
			-clicking on a thread displays a list of all posts in the thread
				-over a certain limit, the list of posts are divided over multiple pages
					-navigate to next/previous page with two buttons, or jump to a specific page with a textfield and button
				-users can create a new post in a thread, which is appended to the end of the list
		-return to the main forums with a button
		-refresh the current page with a button
*/
package forum.ui;

import forum.Forum;
import forum.Thread;
import forum.Post;

import static lib.Time.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UIClientMain extends JPanel implements ActionListener {
	private UINavigationPanel navigationPanel = new UINavigationPanel("UserAnon");
	private UIScrollPane displayScrollPane;
	private UIDisplayPanel displayPanel;
	private UIResponsePanel responsePanel = new UIResponsePanel();


	private Forum forum = new Forum();
	private int currentThreadID = -1;
	private java.util.List<JPanel> panelList = new java.util.ArrayList<>();
	private java.util.List<Integer> idList = new java.util.ArrayList<>();

	public int generateID() {
		int id = 0;

		for(int i = 0; i < idList.size(); i++) {
			if(id == idList.get(i)) {
				i = 0;
				id++;
			}
		}
		idList.add(id);

		return id;
	}

	public void cleanIDList() {
		int index = 0;
		for(int id : idList) {
			boolean idFound = false;

			for(Thread thread : forum.getForum()) {
				if(id == thread.getID()) {
					idFound = true;
				}
			}

			if(!idFound) {
				idList.remove(index);
			}

			index++;
		}
	}

	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == responsePanel.getSubmitButton()) {
			String subject = responsePanel.getSubject();
			String username = navigationPanel.getUsername();
			String date = getFormattedDate();
			String time = getFormattedTime();
			String message = responsePanel.getMessage();

			if(currentThreadID == -1) {
				int id = generateID();

				forum.createThread(subject, username, date, time, message, id);
				refreshForum(forum);
			}
			else {
				Thread thread = forum.getThread(currentThreadID);
				forum.createPost(thread, username, date, time, message);
				refreshThread(thread);
			}
		}
		if(a.getSource() == navigationPanel.getBackButton()) {
			currentThreadID = -1;
			refreshForum(forum);
		}
		if(a.getSource() == navigationPanel.getRefreshButton()) {
			if(currentThreadID == -1) {
				refreshForum(forum);
			}
			else {
				Thread thread = forum.getThread(currentThreadID);
				refreshThread(thread);
			}
		}
	}

	public void createUIActionListeners() {
		navigationPanel.getBackButton().addActionListener(this);
		responsePanel.getSubmitButton().addActionListener(this);
	}

	public UIThreadPanel createUIThread(Thread thread) {
		UIThreadPanel panel = new UIThreadPanel(thread);

		panel.addMouseListener(
			new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					currentThreadID = ((UIThreadPanel)event.getSource()).getID();
					Thread thread = forum.getThread(currentThreadID);
					refreshThread(thread);
				}
			}
		);
		panel.setBorder(BorderFactory.createLineBorder(Color.black,1));
		return panel;
	}

	public UIPostPanel createUIPost(Post post) {
		UIPostPanel panel = new UIPostPanel(post);
		panel.setBorder(BorderFactory.createLineBorder(Color.black,1));

		return panel;
	}

	public void createUIDisplayPanel(Forum forum) {
		panelList.clear();

		for(Thread thread : forum.getForum()) {
			panelList.add(createUIThread(thread));
		}

		displayPanel = new UIDisplayPanel(panelList);
	}

	public void createUIDisplayPanel(Thread thread) {
		panelList.clear();

		for(Post post : thread.getThread()) {
			panelList.add(createUIPost(post));
		}

		displayPanel = new UIDisplayPanel(panelList);
	}

	public void createUIScrollPane() {
		displayScrollPane = new UIScrollPane(displayPanel);
	}

	public void refreshForum(Forum forum) {
		createUIDisplayPanel(forum);
		displayScrollPane.refresh(displayPanel);
	}

	public void refreshThread(Thread thread) {
		createUIDisplayPanel(thread);
		displayScrollPane.refresh(displayPanel);
	}

	public void testThreads() {
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread("Subject: " + i, new Post("User: " + i, getFormattedDate(), getFormattedTime(), "Message: " + i, true), generateID());
			for(int j = 0; j < 5; j++) {
				thread.newPost(new Post("New person: " + j, getFormattedDate(), getFormattedTime(), "Response: " + j, false));
			}
			forum.getForum().add(thread);
		}
	}

	public UIClientMain() {
		testThreads();
		createUIActionListeners();
		createUIDisplayPanel(forum);
		createUIScrollPane();

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;

		add(navigationPanel, gbc);

		gbc.gridy++;
		gbc.weightx = gbc.weighty = 1.0;

		add(displayScrollPane, gbc);

		gbc.gridy++;
		gbc.weightx = gbc.weighty = 0.0;

		responsePanel.setMinimumSize(responsePanel.getPreferredSize());

		add(responsePanel, gbc);
	}
}