package com.snake;

import java.util.Random;

class Food extends Point {
    Random random = new Random();

    public Food() {
        super(-1,-1);
        this.color = Constants.FOOD_COLOR;
    }

    void eat(){
        this.setXY(-1,-1);
    }

    boolean isEaten() {
        return this.getX() == -1;
    }

    void next() {
        int x, y;
        do {
            x = random.nextInt(Constants.FILLED_WIDTH);
            y = random.nextInt(Constants.FILLED_HEIGHT);
        }while(GameSnake.snake.isInsideSnake(x,y));
        this.setXY(x,y);

    }


}
