package com.gamedev.rain.level.tile;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;

public abstract class Tile {

    public int x, y;
    public Sprite sprite;
    private boolean solid = false;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean isSolid() {
        return solid;
    }

}
