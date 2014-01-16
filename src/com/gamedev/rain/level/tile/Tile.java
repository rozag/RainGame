package com.gamedev.rain.level.tile;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;

public abstract class Tile {

    public int x, y;
    public Sprite sprite;
    protected boolean solid = false;

    // Main tiles
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    // Spawn level tiles
    public static Tile spawn_grass = new GrassTile(Sprite.spawn_grass);
    public static Tile spawn_hedge = new GrassTile(Sprite.spawn_hedge);
    public static Tile spawn_water = new GrassTile(Sprite.spawn_water);
    public static Tile spawn_wall_1 = new GrassTile(Sprite.spawn_wall_1);
    public static Tile spawn_wall_2 = new GrassTile(Sprite.spawn_wall_2);
    public static Tile spawn_floor = new GrassTile(Sprite.spawn_floor);

    // Colours of spawn level tiles
    public static final int colour_spawn_grass = 0xff00ff00;
    public static final int colour_spawn_hedge = 0xff267f00;
    public static final int colour_spawn_water = 0xff0000ff;
    public static final int colour_spawn_wall_1 = 0xff404040;
    public static final int colour_spawn_wall_2 = 0xff808080;
    public static final int colour_spawn_floor = 0xff7f0000;

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
