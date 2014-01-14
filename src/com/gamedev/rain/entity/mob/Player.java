package com.gamedev.rain.entity.mob;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;
import com.gamedev.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.playerDown[0];
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.playerDown[0];
    }

    public void update() {
        int xa = 0, ya = 0;

        if (animate < 4000)
            animate++;
        else
            animate = 0;

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

    public void render(Screen screen) {
        boolean xFlip = false, yFlip = false;
        int index = 0;
        if (walking) {
            if (animate % 20 > 10)
                index = 1;
            else
                index = 2;
        }
        if (direction == 0)
            sprite = Sprite.playerUp[index];
        else if (direction == 1)
            sprite = Sprite.playerSide[index];
        else if (direction == 2)
            sprite = Sprite.playerDown[index];
        else {
            sprite = Sprite.playerSide[index];
            xFlip = true;
        }

        screen.renderPlayer(x - 16, y - 16, sprite, xFlip, yFlip);
    }

}
