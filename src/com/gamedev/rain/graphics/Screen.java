package com.gamedev.rain.graphics;

import com.gamedev.rain.level.tile.Tile;

import java.util.Random;

public class Screen {

    public final int MAP_SIZE = 8;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;

    public int xOffset, yOffset;

    public int width, height;
    public int[] pixels;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void render(int xOffset, int yOffset) {
        for (int y = 0; y < height; y++) {
            int yPixel = y + yOffset;
            if (yPixel < 0 || yPixel >= height)
                continue;
            for (int x = 0; x < width; x++) {
                int xPixel = x + xOffset;
                if (xPixel < 0 || xPixel >= width)
                    continue;
                pixels[xPixel + yPixel * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
            }
        }
    }

    public void renderTile(int xPos, int yPos, Tile tile) {
        xPos -= xOffset;
        yPos -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int yAbs = y + yPos;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xAbs = x + xPos;
                if (xAbs < 0 || xAbs >= width || yAbs < 0 || yAbs >= height)
                    break;
                pixels[xAbs + yAbs * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}
