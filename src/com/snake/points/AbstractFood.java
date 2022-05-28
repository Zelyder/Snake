package com.snake.points;

public abstract class AbstractFood extends Point {
    public void eat(){
        this.setXY(-1,-1);
    }

    public boolean isEaten() {
        return this.getX() == -1;
    }

    public AbstractFood(int x, int y) {
        this.setXY(x, y);
    }
}
