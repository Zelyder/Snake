package com.snake.points;

import com.snake.observer.IObservable;
import com.snake.observer.IObserver;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractFood extends Point implements IObservable {
    private Set<IObserver> observers = new HashSet<>();

    public void eat(){
        this.setXY(-1,-1);
    }

    public boolean isEaten() {
        return this.getX() == -1;
    }

    public AbstractFood(int x, int y) {
        this.setXY(x, y);
    }

    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this);
        }
    }
}
