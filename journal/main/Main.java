package main;

import calendar.Calendar;
import forum.ui.UIClientMain;
import initial.DayOne;
import initial.DailyTracker;

import javax.swing.*;
import java.awt.*;

public class Main {
	private Main() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DailyTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DailyTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DailyTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DailyTracker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		GridBagConstraints gbc = new GridBagConstraints();

		JTabbedPane tabbedPane = new JTabbedPane();

		DayOne dayOneTab = new DayOne();
		DailyTracker dailyTrackerTab = new DailyTracker();
		Calendar calendarTab = new Calendar();
		UIClientMain forumTab = new UIClientMain();

		tabbedPane.add("Day One", dayOneTab);
		tabbedPane.add("Daily Tracker", dailyTrackerTab);
		tabbedPane.add("Calendar", calendarTab);
		tabbedPane.add("Forum", forumTab);

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
