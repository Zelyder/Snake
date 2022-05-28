package com.snake.points;

import java.awt.*;

public class PointView {
    private Color color;

    public PointView(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PointView) {
            return ((PointView) obj).color == this.color;
        }
        return super.equals(obj);
    }

    public Color getColor() {
        return color;
    }
}
