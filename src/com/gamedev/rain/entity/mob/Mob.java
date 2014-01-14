package com.gamedev.rain.entity.mob;

import com.gamedev.rain.entity.Entity;
import com.gamedev.rain.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int direction = 2;
    protected boolean moving = false;

    public void move(int x, int y) {
        if (y < 0) direction = 0; // Up
        if (x > 0) direction = 1; // Right
        if (y > 0) direction = 2; // Down
        if (x < 0) direction = 3; // Left

        if (!collision()) {
            this.x += x;
            this.y += y;
        }
    }

    public void update() {
    }

    private boolean collision() {
        return false;
    }

    public void render() {
    }

}
