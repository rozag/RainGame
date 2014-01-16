package com.gamedev.rain.level;

import com.gamedev.rain.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w * h];
            image.getRGB(0, 0, w, h, tiles, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void generateLevel() {
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_grass) return Tile.spawn_grass;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_hedge) return Tile.spawn_hedge;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_water) return Tile.spawn_water;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_wall_1) return Tile.spawn_wall_1;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_wall_2) return Tile.spawn_wall_2;
        else if (x + y * width >= 0 && tiles[x + y * width] == Tile.colour_spawn_floor) return Tile.spawn_floor;
        else return Tile.voidTile;
    }

}
