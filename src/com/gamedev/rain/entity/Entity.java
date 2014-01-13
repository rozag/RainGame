package com.gamedev.rain.entity;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.level.Level;

import java.util.Random;

public abstract class Entity {

    public int x, y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void remove() {
        //Remove the entity from level
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

}
