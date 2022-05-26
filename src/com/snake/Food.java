package com.snake;

import com.snake.observer.IObservable;
import com.snake.observer.IObserver;

import java.util.Random;

class Food extends Point implements IObservable {
    Random random = new Random();
    GameSnake gameSnake;

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


    @Override
    public void registerObserver(IObserver observer) {
        gameSnake = (GameSnake) observer;
    }

    @Override
    public void removeObserver(IObserver observer) {
        gameSnake = null;
    }

    @Override
    public void notifyObservers() {
        gameSnake.update(this);
    }
}
