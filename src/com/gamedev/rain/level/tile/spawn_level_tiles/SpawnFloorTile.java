package com.gamedev.rain.level.tile.spawn_level_tiles;

import com.gamedev.rain.graphics.Sprite;
import com.gamedev.rain.level.tile.Tile;

public class SpawnFloorTile extends Tile {

    public SpawnFloorTile(Sprite sprite) {
        super(sprite);
        solid = false;
    }
}
