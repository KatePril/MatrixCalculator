package app.view.elements.panels;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    private TranspositionPanel matrix;



    public ResultPanel(int size) {
        JLabel label = new JLabel("=");
        add(label);
        matrix = new TranspositionPanel(size);
        add(matrix);
    }


    public TranspositionPanel getMatrix() {
        return matrix;
    }

    public void setMatrix(TranspositionPanel matrix) {
        this.matrix = matrix;
    }


}
