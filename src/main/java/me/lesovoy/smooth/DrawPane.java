package me.lesovoy.smooth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawPane extends JPanel implements Runnable {

    Coordinates boxCoordinates;
    Dimension paneDimensions;
    Box box;

    final Coordinates INITIAL_COORDIANTES = new Coordinates(13.245f, 15.2324f);// new Coordinates(paneDimensions.width / 2, paneDimensions.height / 2);

    public DrawPane(Dimension dimensions) {
        setBackground(Color.GRAY);
        paneDimensions = dimensions;
        boxCoordinates = boxCoordinates == null ? INITIAL_COORDIANTES : boxCoordinates;
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                Coordinates target = Coordinates.getMouseCoordinates(mouseEvent);
                Coordinates delta = Coordinates.getDeltas(boxCoordinates, target, 100);
                transition(target, delta);
            }
        });
    }

    private void doDrawing(Graphics g) {
        box = new Box(boxCoordinates, g);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    public void transition(Coordinates targetCoordinates, Coordinates delta) {
        while (!boxCoordinates.isOn(targetCoordinates, delta)) {
            if (boxCoordinates.lastStep(targetCoordinates, delta)) {
                boxCoordinates = targetCoordinates;
            } else {
                boxCoordinates.increment(delta);
            }
            update(this.getGraphics());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {

    }
}


