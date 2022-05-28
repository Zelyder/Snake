package com.snake.points;

import com.snake.Constants;

import java.awt.*;

public class Point {
    protected int x,y;
    protected PointView pointView;

    public void paint(Graphics g){
        g.setColor(pointView.getColor());
        g.fillOval(x * Constants.POINT_RADIUS, y * Constants.POINT_RADIUS, Constants.POINT_RADIUS, Constants.POINT_RADIUS);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setXY (int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move (int direction) {
        if (direction == Constants.LEFT) {
            this.x--;
        }
        if (direction == Constants.RIGHT) {
            this.x++;
        }
        if (direction == Constants.UP) {
            this.y--;
        }
        if (direction == Constants.DOWN) {
            this.y++;
        }
    }

    public boolean isIntersects(Point point) {
        return point.getX() == this.x && point.getY() == this.y;
    }
}
