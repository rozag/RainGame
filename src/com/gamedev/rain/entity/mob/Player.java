package com.gamedev.rain.entity.mob;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;
import com.gamedev.rain.input.Keyboard;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.playerDown;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.playerDown;
    }

    public void update() {
        int xa = 0, ya = 0;

        if (input.up) ya--;
        if (input.right) xa++;
        if (input.down) ya++;
        if (input.left) xa--;

        if (xa != 0 || ya != 0) move(xa, ya);
    }

    public void render(Screen screen) {
        if (direction == 0) sprite = Sprite.playerUp;
        else if (direction == 1) sprite = Sprite.playerRight;
        else if (direction == 2) sprite = Sprite.playerDown;
        else sprite = Sprite.playerLeft;

        screen.renderPlayer(x - 16, y - 16, sprite);
    }

}
