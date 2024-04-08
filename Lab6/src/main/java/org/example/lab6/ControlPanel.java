package org.example.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.SwingConstants.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Exit, etc.)

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        //setLayout(new GridLayout(1, 4));
        setLayout(new FlowLayout());
        //add all buttons
        frame.add(loadBtn);
        frame.add(saveBtn);
        frame.add(exitBtn);
        //configure listeners for all buttons
        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);

    }

    private void saveGame(ActionEvent actionEvent) {
    }

    private void loadGame(ActionEvent actionEvent) {
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
