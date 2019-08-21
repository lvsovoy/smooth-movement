package me.lesovoy.smooth;

import java.awt.*;

public class Box {
    Coordinates coordinates;

    Graphics2D g2d;

    public Box(Coordinates coordinates, Graphics g) {
        this.coordinates = coordinates;
        this.g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);
        g2d.drawRect(Math.round(coordinates.fx), Math.round(coordinates.fy), 10, 10);
    }
}
