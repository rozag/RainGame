package com.gamedev.rain.entity.projectile;

import com.gamedev.rain.entity.Entity;
import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;

public abstract class Projectile extends Entity {

    protected final int xOrigin, yOrigin;
    protected Sprite sprite;
    protected double angle;
    protected double newX, newY;
    protected double speed;
    protected double rateOfFire;
    protected double range;
    protected double damage;

    public Projectile(int x, int y, double angle) {
        this.xOrigin = x;
        this.yOrigin = y;
        this.angle = angle;
        this.x = xOrigin;
        this.y = yOrigin;
    }

    public void update() {
        move();
    }

    protected void move() {
        x += newX;
        y += newY;
    }

    public void render(Screen screen) {
        screen.renderTile(x, y, sprite);
    }

}
