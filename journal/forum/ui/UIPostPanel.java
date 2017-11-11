package forum.ui;

import forum.Post;

import javax.swing.*;
import java.awt.*;

public class UIPostPanel extends JPanel {
	public UIPostPanel(Post post) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JTextArea message = new JTextArea(post.getMessage());
		message.setLineWrap(true);
		message.setEditable(false);
		message.setRows(2);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		add(new JLabel(post.getUsername()), gbc);
		gbc.gridx++;
		add(new JLabel(post.getDate()), gbc);
		gbc.gridx++;
		add(new JLabel(post.getTime()), gbc);

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.gridwidth = 3;
		add(message, gbc);
	}
}
