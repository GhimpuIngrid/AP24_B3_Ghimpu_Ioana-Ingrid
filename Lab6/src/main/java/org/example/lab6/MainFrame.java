package org.example.lab6;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame{
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        setLayout(new BorderLayout());

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        this.add(configPanel, BorderLayout.PAGE_START);
        this.add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        this.add(controlPanel, BorderLayout.PAGE_END);

        //invoke the layout manager

        this.pack();

    }

}
