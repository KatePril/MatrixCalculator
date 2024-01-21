package app.view.elements;

import javax.swing.*;

public class SizeSelector extends JComboBox<Integer> {

    public SizeSelector(int selectedItem) {
        super(new Integer[]{2, 3, 4, 5});
        setSelectedItem(selectedItem);
    }
}
