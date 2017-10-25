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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Client implements ActionListener {
	private JButton backButton = new JButton("return");
	private JButton refreshButton = new JButton("refresh");
	private JButton previousPageButton = new JButton("<");
	private JButton nextPageButton = new JButton(">");
	private JButton jumpToPageButton = new JButton("Go");
	private JButton responseButton = new JButton("Placeholder text");

	private JScrollPane scrollPane;

	private JPanel responsePanel = new JPanel(new GridBagLayout());
	private JPanel navigationPanel = new JPanel(new GridBagLayout());
	private JPanel threadPanel = new JPanel(new GridBagLayout());
	private JPanel forumPanel = new JPanel(new GridBagLayout());

	private JLabel nameTag = new JLabel("Insert Username");

	private JTextField pageField = new JTextField(4);
	private JTextField subjectField = new JTextField("Subject",30);
	private JTextArea messageArea = new JTextArea("Message body", 5, 30);

	private JTabbedPane forumTab = new JTabbedPane();

	private final GridBagConstraints gbc = new GridBagConstraints();

	private static java.util.List<Thread> forum = new java.util.ArrayList<Thread>();
	private static java.util.List<JPanel> panelList = new java.util.ArrayList<JPanel>();

	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == responseButton) {
			createThread(subjectField.getText(), nameTag.getText(), "1992", "1001", messageArea.getText());
			refreshForum();
		}
	}
	public void initializeResponsePanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;

		messageArea.setLineWrap(true);
		responseButton.addActionListener(this);

		responsePanel.add(responseButton, gbc);
		gbc.gridx++;
		responsePanel.add(messageArea, gbc);
		gbc.gridy--;
		responsePanel.add(subjectField, gbc);
	}

	public void initializeNavigationPanel() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		navigationPanel.add(nameTag, gbc);
		gbc.gridx++;
		navigationPanel.add(backButton, gbc);
		gbc.gridx++;
		navigationPanel.add(refreshButton, gbc);
		gbc.gridx++;
		navigationPanel.add(previousPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(pageField, gbc);
		gbc.gridx++;
		navigationPanel.add(jumpToPageButton, gbc);
		gbc.gridx++;
		navigationPanel.add(nextPageButton, gbc);
	}

	public void createThread(String subject, String username, String date, String time, String message) {
		forum.add(new Thread(subject, new Post(username, date, time, message,true)));
	}

	public JPanel formatForumView(Thread thread, int index) {
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

		return panel;
	}

	//public void formatThreadView(Thread thread) {}

	public void displayForum() {
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;

		int index = 0;
		for(Thread thread : forum) {
			panelList.add(formatForumView(thread, index));
			threadPanel.add(panelList.get(index), gbc);
			gbc.gridy++;
			index++;
		}

		gbc.gridx = 0;
		gbc.gridy = 0;

		scrollPane = new JScrollPane(threadPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		initializeResponsePanel();
		initializeNavigationPanel();

		forumPanel.add(navigationPanel, gbc);
		gbc.gridy++;
		forumPanel.add(scrollPane, gbc);
		gbc.gridy++;
		forumPanel.add(responsePanel,gbc);
		forumTab.add("Forum", forumPanel);
	}

	public void refreshForum() {
		//forumTab.remove(threadPanel);
		panelList.clear();

		displayForum();

		forumTab.revalidate();
		forumTab.repaint();
	}

	//public void initializeForum() {}
	//public void displayThread() {}

	public void testCreateThreads() {
		createThread("subject1", "name1", "1992", "1200", "ass1");
		createThread("subject2", "name2", "1993", "1201", "ass2");
		createThread("subject3", "name3", "1994", "1202", "ass3");
		createThread("subject4", "name4", "1995", "1203", "ass4");
		createThread("subject5", "name5", "1996", "1204", "ass5");
//		refreshForum();
	}

	public void testCreatePosts() {

	}

	public Client() {
		testCreateThreads();
		displayForum();

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

}