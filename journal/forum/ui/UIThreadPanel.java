package forum.ui;

import forum.Thread;

import javax.swing.*;
import java.awt.*;

public class UIThreadPanel extends JPanel {
	private int id;

	public int getID() {return id;}

	public UIThreadPanel(Thread thread) {
        setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		id = thread.getID();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		add(new JLabel(thread.getUsername()), gbc);
		gbc.gridx++;
		add(new JLabel(thread.getDate()), gbc);
		gbc.gridx++;
		add(new JLabel(thread.getTime()), gbc);

		gbc.gridwidth = 3;
		gbc.gridx = 0;
		gbc.gridy++;
		add(new JLabel(thread.getSubject()), gbc);
	}
}
