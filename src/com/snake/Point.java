package com.snake;

import java.awt.*;

public class Point {
    int x,y;
    Color color = Constants.DEFAULT_COLOR;

    public Point(int x, int y) {
        this.setXY(x, y);
    }
    void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x * Constants.POINT_RADIUS, y*Constants.POINT_RADIUS, Constants.POINT_RADIUS, Constants.POINT_RADIUS);
    }

    int getX() {
        return x;
    }
    int getY() {
        return y;
    }

    void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
