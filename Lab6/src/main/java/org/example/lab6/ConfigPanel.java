package org.example.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerRows;
    JSpinner spinnerCols;
    JButton createBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        createBtn = new JButton("Create");

        createBtn.addActionListener(this::createGame);

        //create spinners for rows and cols, and the button

        setLayout(new FlowLayout());

        frame.add(label); //JPanel uses FlowLayout by default
        frame.add(spinnerRows);
        frame.add(spinnerCols);
        frame.add(createBtn);
    }

    private void createGame(ActionEvent actionEvent) {

    }

    public int getRows() {
        return (int) spinnerRows.getValue();
    }

    public int getCols() {
        return (int) spinnerCols.getValue();
    }
}
