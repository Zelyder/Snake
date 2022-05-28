package com.snake;

import com.snake.points.AbstractFood;
import com.snake.points.AbstractPointFactory;
import com.snake.points.apple.AppleFactory;
import com.snake.points.pear.PearFactory;

import java.util.*;
import java.awt.Color;
import java.awt.BorderLayout;
import com.snake.observer.IObserver;
import java.awt.event.*;
import javax.swing.*;

public class GameSnake implements IObserver {
    public static Snake snake;
    public static AbstractPointFactory pointFactory;
    public static List<AbstractFood> food = new ArrayList<>();
    public static int score = 0;
    static JFrame frame;
    Canvas canvasPanel;
    public static boolean gameOver = false;

    public static void main(String[] args) {
        new GameSnake().go();
    }
    void go(){
        pointFactory = new AppleFactory();
        snake = new Snake(Constants.START_SNAKE_X, Constants.START_SNAKE_Y, Constants.START_SNAKE_SIZE, Constants.START_DIRECTION);
        fillFood();
        frame = new JFrame(Constants.TITLE_OF_PROGRAM + ". Score : " + score);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.FILLED_WIDTH * Constants.POINT_RADIUS + Constants.FILLED_DX, Constants.FILLED_HEIGHT * Constants.POINT_RADIUS + Constants.FILLED_DY);
        frame.setLocation(Constants.START_LOCATION,Constants.START_LOCATION);
        frame.setResizable(false);

        canvasPanel = new Canvas();
        canvasPanel.setBackground(Color.white);

        frame.getContentPane().add(BorderLayout.CENTER, canvasPanel);
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
            }
        });
        frame.setVisible(true);

        while(!gameOver) {
            snake.move();
            for (int i = 0; i < GameSnake.food.size(); i++) {
                if (GameSnake.food.get(i).isEaten()) {
                    food.remove(i);
                    AbstractFood newFood = pointFactory.createFood();
                    newFood.registerObserver(this);
                    food.add(newFood);
                }
            }
            if (score == 10 && !(pointFactory instanceof PearFactory)) {
                pointFactory = new PearFactory();
                food.clear();
                fillFood();
            }
            canvasPanel.repaint();
            try {
                Thread.sleep(Constants.SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void fillFood() {
        for (int i = 0; i < pointFactory.getFoodCount(); i++) {
            AbstractFood newFood = pointFactory.createFood();
            newFood.registerObserver(this);
            food.add(newFood);
        }
    }

    @Override
    public void update(Object food) {
        if (food instanceof AbstractFood foodCasted) {
            foodCasted.eat();
            score += 1;
            frame.setTitle(Constants.TITLE_OF_PROGRAM + ". Score : " + score);
        }
    }

}