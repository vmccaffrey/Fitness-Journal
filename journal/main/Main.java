package main;

import calendar.Calendar;
import forum.ui.UIClientMain;
import initial.DayOne;

import javax.swing.*;
import java.awt.*;

public class Main {
	private Main() {
		GridBagConstraints gbc = new GridBagConstraints();

		JTabbedPane tabbedPane = new JTabbedPane();

		DayOne dayOneTab = new DayOne();
		UIClientMain forumTab = new UIClientMain();
		Calendar calendar = new Calendar();

		tabbedPane.add("Day One", dayOneTab);
		tabbedPane.add("Forum", forumTab);
		tabbedPane.add("Calendar", calendar);

		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;

		JFrame frame = new JFrame("Fitness Journal");
		frame.setLayout(new GridBagLayout());
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.add(tabbedPane, gbc);
		frame.pack();
	}

	public static void main(String args[]) {
		Main main = new Main();
	}

}
