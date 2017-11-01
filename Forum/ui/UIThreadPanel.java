package ui;

import forum.Thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UIThreadPanel extends JPanel {
    public UIThreadPanel(Thread thread) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 0;

        panel.add(new JLabel("Subject: " + thread.getSubject()), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Username: " + thread.getUsername()), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Date: " + thread.getDate()), gbc);
        gbc.gridy++;
        panel.add(new JLabel("Time: " + thread.getTime()), gbc);

        panel.setPreferredSize(new Dimension(200,200));

        panel.addMouseListener(
            new MouseListener() {
                public void mouseReleased(MouseEvent event) {}
                public void mousePressed(MouseEvent event) {}
                public void mouseExited(MouseEvent event) {}
                public void mouseEntered(MouseEvent event) {}
                public void mouseClicked(MouseEvent event) {}
            }
        );
    }
}
