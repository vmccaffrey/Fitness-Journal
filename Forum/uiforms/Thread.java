package uiforms;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Thread {
    private JPanel threadPanel;

    public Thread() {
        threadPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });
    }
}
