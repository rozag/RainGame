package com.gamedev.rain.entity.mob;

import com.gamedev.rain.Game;
import com.gamedev.rain.entity.projectile.Projectile;
import com.gamedev.rain.entity.projectile.WizardProjectile;
import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;
import com.gamedev.rain.input.Keyboard;
import com.gamedev.rain.input.Mouse;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.wizardDown[0];
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.wizardDown[0];
    }

    protected void shoot(int x, int y, double shootDirection) {
        Projectile p = new WizardProjectile(x, y, shootDirection);
        projectiles.add(p);
        level.add(p);
    }

    public void update() {
        int xa = 0, ya = 0;

        if (animate < 4000)
            animate++;
        else
            animate = 0;

        updateShooting();

        if (input.up) ya--;
        if (input.right) xa++;
        if (input.down) ya++;
        if (input.left) xa--;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    private void updateShooting() {
        if (Mouse.getButton() == 1) {
            double shootDirection = Math.atan2(Mouse.getY() - Game.getWindowHeight() / 2, Mouse.getX() - Game.getWindowWidth() / 2);
            shoot(x, y, shootDirection);
        }
    }

    public void render(Screen screen) {
        boolean xFlip = false, yFlip = false;
        int index = 0;
        if (walking) {
            if (animate % 20 > 10)
                index = 1;
            else
                index = 2;
        }
//        if (direction == 0) sprite = Sprite.knightUp[index];
//        else if (direction == 1) sprite = Sprite.knightSide[index];
//        else if (direction == 2) sprite = Sprite.knightDown[index];
//        else {
//            sprite = Sprite.knightSide[index];
//            xFlip = true;
//        }
        if (direction == 0) sprite = Sprite.wizardUp[index];
        else if (direction == 1) sprite = Sprite.wizardSide[index];
        else if (direction == 2) sprite = Sprite.wizardDown[index];
        else {
            sprite = Sprite.wizardSide[index];
            xFlip = true;
        }

        screen.renderPlayer(x - 8, y - 8, sprite, xFlip, yFlip);
    }

}
