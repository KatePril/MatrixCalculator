package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class TranspositionPanel extends JPanel {

    private JButton button = new JButton("Transpose");

    public TranspositionPanel(int size) {
        MatrixPanel panel = new MatrixPanel(size);

        button.setPreferredSize(new Dimension(panel.getWidth(), 40));
        setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()+60));

        add(panel);
        add(button);
    }
}
