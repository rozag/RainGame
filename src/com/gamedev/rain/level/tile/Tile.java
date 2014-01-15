package com.gamedev.rain.level.tile;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;

public abstract class Tile {

    public int x, y;
    public Sprite sprite;
    protected boolean solid = false;

    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile stone = new StoneTile(Sprite.stone);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);   // (x << 4) <=> (x * 16)
    }

    public boolean isSolid() {
        return solid;
    }

}
