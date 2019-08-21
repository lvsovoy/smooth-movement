package me.lesovoy.smooth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JFrame {

    Dimension DIMENSION = new Dimension(400, 400);

    public MainPanel() {
        initUI();
    }

    private void initUI() {
        DrawPane drawPane = new DrawPane(DIMENSION);
        drawPane.setPreferredSize(DIMENSION);
        add(drawPane);
        setTitle("Panel");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MainPanel mainPanel = new MainPanel();
            mainPanel.setVisible(true);
        });
    }
}

