package forum.ui;

import javax.swing.*;

public class UIScrollPane extends JScrollPane {
	public void refresh(JPanel panel) {
		setViewportView(panel);
		revalidate();
		repaint();
	}
	public UIScrollPane(UIDisplayPanel panel) {
		setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
		setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
		setViewportView(panel);
	}
}
