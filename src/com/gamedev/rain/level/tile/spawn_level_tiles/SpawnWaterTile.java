package com.gamedev.rain.level.tile.spawn_level_tiles;

import com.gamedev.rain.graphics.Screen;
import com.gamedev.rain.graphics.Sprite;
import com.gamedev.rain.level.tile.Tile;

public class SpawnWaterTile extends Tile {

    public SpawnWaterTile(Sprite sprite) {
        super(sprite);
        solid = true;
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this); // (x << 4) <=> (x * 16)
    }
}
