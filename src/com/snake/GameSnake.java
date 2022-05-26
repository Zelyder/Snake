package com.snake;

import com.snake.observer.IObserver;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GameSnake implements IObserver {
    static Snake snake;
    public static Food food;
    public static int score = 0;
    //Poison poison;
    static JFrame frame;
    Canvas canvasPanel;
    public static boolean gameOver = false;


    public static void main(String[] args) {
        new GameSnake().go();
    }
    void go(){
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
                //  System.out.println(e.getKeyCode());
            }
        });
        frame.setVisible(true);

        snake = new Snake(Constants.START_SNAKE_X, Constants.START_SNAKE_Y, Constants.START_SNAKE_SIZE, Constants.START_DIRECTION);
        food = new Food();
        food.registerObserver(this);

        while(!gameOver) {
            snake.move();
            if(food.isEaten()){
                food.next();
            }
            canvasPanel.repaint();
            try {
                Thread.sleep(Constants.SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Object obj) {
        food.eat();
        score += 1;
        frame.setTitle(Constants.TITLE_OF_PROGRAM + ". Score : " + score);
    }
}