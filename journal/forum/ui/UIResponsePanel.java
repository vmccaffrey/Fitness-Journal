package forum.ui;

import javax.swing.*;
import java.awt.*;

public class UIResponsePanel extends JPanel {
	private JButton submitButton = new JButton("Submit");
	private JTextField subjectField = new JTextField("Subject",60);
	private JTextArea messageArea = new JTextArea("Message body", 5, 60);

	public JButton getSubmitButton() {return submitButton;}

	public String getSubject() {return subjectField.getText();}
	public String getMessage() {return messageArea.getText();}

	public UIResponsePanel() {
		JScrollPane messageScrollPane;
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 1;

		add(submitButton, gbc);

		gbc.weightx = 1.0;
		gbc.gridheight = 1;
		gbc.gridx++;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		messageArea.setLineWrap(true);
		messageScrollPane = new JScrollPane(messageArea);

		add(messageScrollPane, gbc);
		gbc.gridy--;
		add(subjectField, gbc);
	}
}
