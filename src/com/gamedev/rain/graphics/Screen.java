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

    public void renderTile(int xPos, int yPos, Tile tile) {
        xPos -= xOffset;
        yPos -= yOffset;
        for (int y = 0; y < tile.sprite.SIZE; y++) {
            int yAbs = y + yPos;
            for (int x = 0; x < tile.sprite.SIZE; x++) {
                int xAbs = x + xPos;
                if (xAbs < -tile.sprite.SIZE || xAbs >= width || yAbs < -tile.sprite.SIZE || yAbs >= height)
                    break;
                if (xAbs < 0)
                    xAbs = 0;
                if (yAbs < 0)
                    yAbs = 0;
                pixels[xAbs + yAbs * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void renderPlayer(int xPos, int yPos, Sprite sprite) {
        xPos -= xOffset;
        yPos -= yOffset;
        for (int y = 0; y < 32; y++) {
            int yAbs = y + yPos;
            for (int x = 0; x < 32; x++) {
                int xAbs = x + xPos;
                if (xAbs < -32 || xAbs >= width || yAbs < -32 || yAbs >= height)
                    break;
                if (xAbs < 0)
                    xAbs = 0;
                if (yAbs < 0)
                    yAbs = 0;

                int colour = sprite.pixels[x + y * 32];
                if (colour != 0xffff00ff)
                    pixels[xAbs + yAbs * width] = colour;
            }
        }
    }

    public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}
