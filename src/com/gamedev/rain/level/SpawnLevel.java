package com.gamedev.rain.level;

import com.gamedev.rain.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpawnLevel extends Level {

    private int[] levelPixels;

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int width = image.getWidth(), height = image.getHeight();
            tiles = new Tile[width * height];
            levelPixels = new int[width * height];
            image.getRGB(0, 0, width, height, levelPixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 0xff00ff00 - grass
    // 0xffffff00 - flower
    // 0xff7f0000 - stone
    protected void generateLevel() {
        for (int i = 0; i < levelPixels.length; i++) {
            if (levelPixels[i] == 0xff00ff00) tiles[i] = Tile.grass;
            else if (levelPixels[i] == 0xffffff00) tiles[i] = Tile.flower;
            else if (levelPixels[i] == 0xff7f0000) tiles[i] = Tile.stone;
        }
    }

}
