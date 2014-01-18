package com.gamedev.rain.graphics;

import java.util.Random;

public class Screen {

    public final int MAP_SIZE = 8;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;

    public int xOffset, yOffset;

    public int width, height;
    public int[] pixels;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = (new Random()).nextInt(0xffffff);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int xPos, int yPos, Sprite sprite) {
        xPos -= xOffset;
        yPos -= yOffset;
        for (int y = 0; y < sprite.SIZE; y++) {
            int yAbs = y + yPos;
            for (int x = 0; x < sprite.SIZE; x++) {
                int xAbs = x + xPos;
                if (xAbs < -sprite.SIZE || xAbs >= width || yAbs < -sprite.SIZE || yAbs >= height)
                    break;
                if (xAbs < 0)
                    xAbs = 0;
                if (yAbs < 0)
                    yAbs = 0;
                pixels[xAbs + yAbs * width] = sprite.pixels[x + y * sprite.SIZE];
            }
        }
    }

    public void renderPlayer(int xPos, int yPos, Sprite sprite, boolean xFlip, boolean yFlip) {
        xPos -= xOffset;
        yPos -= yOffset;

        for (int y = 0; y < sprite.SIZE; y++) {
            int yAbs = y + yPos;
            int ys = y;
            if (yFlip)
                ys = sprite.SIZE - 1 - y;
            for (int x = 0; x < sprite.SIZE; x++) {
                int xs = x;
                if (xFlip)
                    xs = sprite.SIZE - 1 - x;
                int xAbs = x + xPos;
                if (xAbs < -sprite.SIZE || xAbs >= width || yAbs < -sprite.SIZE || yAbs >= height)
                    break;
                if (xAbs < 0)
                    xAbs = 0;
                if (yAbs < 0)
                    yAbs = 0;

                int colour = sprite.pixels[xs + ys * sprite.SIZE];
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
