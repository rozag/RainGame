package com.gamedev.rain.entity.mob;

import com.gamedev.rain.entity.Entity;
import com.gamedev.rain.entity.projectile.Projectile;
import com.gamedev.rain.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int direction = 2;
    protected boolean walking = false;
    protected int animate = 0;

    protected List<Projectile> projectiles = new ArrayList<Projectile>();

    protected void shoot(int x, int y, double shootDirection) {
    }

    public void move(int x, int y) {
        if (y < 0) direction = 0; // Up
        if (x > 0) direction = 1; // Right
        if (y > 0) direction = 2; // Down
        if (x < 0) direction = 3; // Left

        if (!collision(x, 0)) this.x += x;
        if (!collision(0, y)) this.y += y;
    }

    public void update() {
    }

    private boolean collision(int x, int y) {
        boolean solid = false;
        for (int i = 0; i < 4; i++) {
            /* Magic numbers! Care! */
            int xTmp = (this.x + x + /* from this */ i % 2 * 12 - 7 /* to this*/) / 16;
            int yTmp = (this.y + y + /* from this */ i / 2 * 12 - 5 /* to this*/) / 16;
            if (level.getTile(xTmp, yTmp).isSolid())
                solid = true;
        }

        return solid;
    }

    public void render() {
    }

}
