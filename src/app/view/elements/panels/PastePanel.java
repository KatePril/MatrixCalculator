package app.view.elements.panels;

import javax.swing.*;

public class PastePanel extends JPanel {
    private JButton pasteAButton = new JButton("Paste result into A");
    private JButton pasteBButton = new JButton("Paste result into B");

    public PastePanel() {;
        add(pasteAButton);
        add(pasteBButton);
    }

    public JButton getPasteAButton() {
        return pasteAButton;
    }

    public void setPasteAButton(JButton pasteA) {
        this.pasteAButton = pasteA;
    }

    public JButton getPasteBButton() {
        return pasteBButton;
    }

    public void setPasteBButton(JButton pasteB) {
        this.pasteBButton = pasteB;
    }
}
