package app.view.elements.panels;

import javax.swing.*;

public class PastePanel extends JPanel {
    private final JButton pasteMatrixAButton = new JButton("Paste result into A");
    private final JButton pasteMatrixBButton = new JButton("Paste result into B");

    public PastePanel() {;
        add(pasteMatrixAButton);
        add(pasteMatrixBButton);
    }

    public JButton getPasteMatrixAButton() {
        return pasteMatrixAButton;
    }

    public JButton getPasteMatrixBButton() {
        return pasteMatrixBButton;
    }
}
