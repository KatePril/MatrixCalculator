package app.view.elements;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    private final int WIDTH = 1500;
    private final int HEIGHT = 800;

    private final int X = 100;
    private final int Y =  100;

    public CalculatorFrame(String title){
        super(title);
        setSize(WIDTH, HEIGHT);
        setLocation(X, Y);
    }

}
