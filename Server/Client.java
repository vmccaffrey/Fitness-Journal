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
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Client {
	
	public Client() {
		JPanel forumTab = new JPanel(new GridBagLayout());
		JLabel testLabel = new JLabel("Test Text, Test Text, Test Text, Test Text, Test Text, Test Text, Test Text");
		JTabbedPane tabbedPane = new JTabbedPane();
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		forumTab.add(testLabel, gbc);
		
		tabbedPane.add("Forum", forumTab);
		
		JFrame frame = new JFrame("Fitness Journal");
		frame.setLayout(new GridBagLayout());
		frame.add(tabbedPane, gbc);
		frame.setMinimumSize(new Dimension(650, 500));
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		Client test = new Client();
	}

}