package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    public ResultPanel(int size) {
        JLabel label = new JLabel("=");
        add(label);
        MatrixPanel panel = new MatrixPanel(size);
        add(panel);
    }
}
