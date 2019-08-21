package me.lesovoy.smooth;

import java.awt.event.MouseEvent;

public class Coordinates {
    public float fx;
    public float fy;


    public Coordinates(int x, int y) {
        this.fx = x;
        this.fy = y;
    }

    public Coordinates(float fx, float fy) {
        this.fx = fx;
        this.fy = fy;
    }

    public static Coordinates getMouseCoordinates(MouseEvent mouseEvent) {
        return new Coordinates(mouseEvent.getX(), mouseEvent.getY());
    }

    public static Coordinates getDeltas(Coordinates initial, Coordinates target, int steps) {
        float dX = (target.fx - initial.fx) / steps;
        float dY = (target.fy - initial.fy) / steps;
        return new Coordinates(dX, dY);
    }

    public void increment(Coordinates delta) {
        this.fx += delta.fx;
        this.fy += delta.fy;
    }

    public boolean isOn(Coordinates target, Coordinates delta) {
        return (this.fx == target.fx && this.fy == target.fy);
    }

    public boolean lastStep(Coordinates target, Coordinates delta) {
        return (delta.fx > 0 && this.fx + delta.fx > target.fx) ||
                (delta.fx < 0 && this.fx + delta.fx < target.fx) ||
                (delta.fy > 0 && this.fy + delta.fy > target.fy) ||
                (delta.fy < 0 && this.fy + delta.fy < target.fy);
    }

}
