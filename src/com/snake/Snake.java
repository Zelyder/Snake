package com.snake;

import com.snake.points.AbstractFood;
import com.snake.points.AbstractSnakeSegment;
import com.snake.points.Point;

import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<AbstractSnakeSegment> snake = new ArrayList<>();
    int direction;

    public Snake(int x, int y, int length, int direction){
        for(int i = 0; i < length; i++){
            snake.add(GameSnake.pointFactory.createSnakeSegment(x-i, y));
        }
        this.direction = direction;
    }
    public boolean isInsideSnake(Point point){
        for(Point segment : snake){
            if(segment.isIntersects(point)) {
                return true;
            }
        }
        return false;
    }

    boolean isFeed () {
        for (AbstractFood food : GameSnake.food) {
            if (snake.get(0).isIntersects(food)) {
                food.eat();
                return true;
            }
        }
        return false;
    }
    void move(){
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if(direction == Constants.LEFT){x--;}
        if(direction == Constants.RIGHT){x++;}
        if(direction == Constants.UP){y--;}
        if(direction == Constants.DOWN){y++;}
        if(x > Constants.FILLED_WIDTH - 1){x=0;}
        if(x < 0){x = Constants.FILLED_WIDTH-1;}
        if(y > Constants.FILLED_HEIGHT - 1){y=0;}
        if(y < 0){y = Constants.FILLED_HEIGHT-1;}
        AbstractSnakeSegment newSegment = GameSnake.pointFactory.createSnakeSegment(x, y);
        GameSnake.gameOver = isInsideSnake(newSegment);
        snake.add(0, newSegment);
        if (isFeed()) {
            GameSnake.frame.setTitle(Constants.TITLE_OF_PROGRAM + " : " + snake.size());
        }else{
            snake.remove(snake.size() - 1);
        }
    }

    void setDirection(int direction){
        if ((direction>=Constants.LEFT) && (direction<=Constants.DOWN)){
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    void paint (Graphics g){
        for(Point point : snake) {
            point.paint(g);
        }
    }

    public int getSize() {
        return snake.size();
    }
}
