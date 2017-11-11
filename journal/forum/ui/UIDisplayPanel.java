package forum.ui;

import javax.swing.*;
import java.awt.*;

public class UIDisplayPanel extends JPanel {
    public UIDisplayPanel(java.util.List<JPanel> panelList) {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		int size = panelList.size();

		gbc.gridx = 0;
		gbc.gridy = size;
		if(panelList.get(0).getClass() == UIPostPanel.class) {
			gbc.gridy = 0;
		}
		gbc.weightx = 1.0;
		gbc.weighty = 0.0;
		gbc.fill = GridBagConstraints.BOTH;

		for(JPanel panel : panelList) {
			if(panel.getClass() == UIThreadPanel.class) {
				add(panel, gbc);
				gbc.gridy--;
			}
			else {
				add(panel, gbc);
				gbc.gridy++;
			}
		}
	}
}
