package com.snake.points;

import com.snake.Constants;

import java.awt.*;

public abstract class AbstractSnakeSegment extends Point {
    public AbstractSnakeSegment(int x, int y) {
        this.setXY(x, y);
    }

    public AbstractSnakeSegment(AbstractSnakeSegment segment) {
        this.x = segment.getX();
        this.y = segment.getY();
        this.pointView = segment.pointView;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.pointView.getColor());
        g.fillRoundRect (
                x * Constants.POINT_RADIUS,
                y * Constants.POINT_RADIUS,
                Constants.POINT_RADIUS,
                Constants.POINT_RADIUS,
                Constants.ARC_RADIUS,
                Constants.ARC_RADIUS);
    }
}
